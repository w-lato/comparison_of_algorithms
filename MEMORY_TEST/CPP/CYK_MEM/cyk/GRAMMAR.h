//
// Created by vm on 02.11.17.
//

#ifndef UNTITLED2_GRAMMAR_H
#define UNTITLED2_GRAMMAR_H

#include <string>
#include <vector>
#include <fstream>
#include <iterator>
#include <list>
#include <sstream>
#include <set>
#include <algorithm>
#include <utility>
#include <memory>

namespace MB
{

    namespace detail
    {

// Split a string
        template <class OutputIt>
        OutputIt string_split(const std::string& str, OutputIt it, char delim = ' ')
        {
            std::stringstream ss(str);
            std::string token;
            while (std::getline(ss, token, delim)) {
                if (token[0] != delim) {
                    *it++ = token;
                }
            }
            return it;
        }

// Form the cartesian product of two sequences
        template <class InputIt1, class InputIt2, class OutputIt>
        OutputIt cartesian_product(InputIt1 begin1, InputIt1 end1, InputIt2 begin2, InputIt2 end2,
                                   OutputIt it)
        {
            for (InputIt1 it1 = begin1; it1 != end1; ++it1) {
                for (InputIt2 it2 = begin2; it2 != end2; ++it2) {
                    *it++ = std::make_pair(*it1, *it2);
                }
            }
            return it;
        }

    } // namespace detail

    class rule
    {
    public:
        typedef std::shared_ptr<rule> ptr;
        typedef std::shared_ptr<const rule> const_ptr;
        rule(const rule&) = delete;
        rule& operator=(const rule&) = delete;
        operator bool()
        {
            return succeeded_;
        }
    private:
        std::string left_;
        std::vector<std::vector<std::string> > right_;
        bool succeeded_;
        rule(const std::string& left, const std::string& right)
                : left_(left)
        {
            right_.push_back(std::vector<std::string>(1, right));
        }
        rule(const std::string &str)
        {
            std::list<std::string> tokens;
            detail::string_split(str, std::back_inserter(tokens));
            succeeded_ = tokens.size();
            std::string token;
            // Get left-hand side
            if (succeeded_) {
                left_ = tokens.front();
                tokens.pop_front();
                succeeded_ = tokens.size();
            }
            // Get arrow
            if (succeeded_) {
                token = tokens.front();
                tokens.pop_front();
                succeeded_ = token == "->" && tokens.size();
            }
            // Get right-hand side
            if (succeeded_) {
                right_.push_back(std::vector<std::string>());
                while (tokens.size()) {
                    token = tokens.front();
                    tokens.pop_front();
                    if (token == "|") {
                        // Start of a new alternative
                        right_.push_back(std::vector<std::string>());
                    }
                    else {
                        // Add this token to current alternative
                        right_.back().push_back(token);
                    }
                }
            }
        }
    public:
        static ptr create(const std::string& left, const std::string& right)
        {
            return ptr(new rule(left, right));
        }
        static ptr create(const std::string& line)
        {
            return ptr(new rule(line));
        }
        const std::string& left() const
        {
            return left_;
        }
        const std::vector<std::vector<std::string> >& right() const
        {
            return right_;
        }
        friend std::ostream& operator <<(std::ostream& os, const rule& r)
        {
            os << r.left_ << " -> ";
            unsigned int i = 0;
            for (const std::vector<std::string>& alternative : r.right_) {
                for (const std::string& symbol: alternative) {
                    os << symbol << " ";
                }
                if (i++ < r.right_.size() - 1) {
                    os << "| ";
                }
            }
            return os;
        }
    };

    class grammar
    {
    public:
        // Create from a stream
        grammar(std::istream& is)
        {
            std::string line;
            while (std::getline(is, line)) {
                line.erase(line.find_last_not_of("\r\n") + 1);
                if (line.size()) {
                    rule::ptr r = rule::create(line);
                    if (*r) {
                        rules_.push_back(r);
                    }
                }
            }
            // Get the terminals
            std::set<std::string> nonterminals;
            std::set<std::string> symbols;
            for (rule::const_ptr r : rules_) {
                nonterminals.insert(r->left());
                for (const std::vector<std::string>& alternative : r->right()) {
                    for (const std::string& symbol : alternative) {
                        symbols.insert(symbol);
                    }
                }
            }
            for (const std::string& symbol : symbols) {
                if (nonterminals.find(symbol) == nonterminals.end()) {
                    terminals_.push_back(symbol);
                }
            }
        }

        // Get all of the rules where symbol is the subject
        template <class OutputIt>
        OutputIt get_rules_for_left(const std::string& symbol, OutputIt it) const
        {
            for (rule::const_ptr r : rules_) {
                if (r->left() == symbol) {
                    *it++ = r;
                }
            }
            return it;
        }

        // Is this symbol a terminal (doesn't occur as the subject of a rule)?
        bool symbol_is_terminal(const std::string& symbol) const
        {
            return std::find(terminals_.begin(), terminals_.end(), symbol) != terminals_.end();
        }

        // Get the rule(s) whose left-hand side is the start symbol
        template <class OutputIt>
        OutputIt get_start_rules(OutputIt it) const
        {
            std::string start_symbol;
            bool started = false;
            for (rule::const_ptr r : rules_) {
                if (!started || r->left() == start_symbol) {
                    *it++ = r;
                }
                if (!started) {
                    started = true;
                    start_symbol = r->left();
                }
            }
            return it;
        }

        // Get the rules where any of these pairs of symbols occur together as a right hand side
        // alternative
        template <class InputIt, class OutputIt>
        OutputIt get_rules_for_symbols(InputIt begin, InputIt end, OutputIt it) const
        {
            for (InputIt init = begin; init != end; ++init) {
                for (rule::const_ptr r : rules_) {
                    for (const std::vector<std::string>& alternative : r->right()) {
                        if (alternative.size() == 2
                            && alternative[0] == init->first
                            && alternative[1] == init->second) {
                            *it++ = r;
                        }
                    }
                }
            }
            return it;
        }

        // Get the rules where this symbol occurs in a right hand side alternative
        template <class OutputIt>
        OutputIt get_rules_for_symbol(const std::string& symbol, OutputIt it) const
        {
            for (rule::const_ptr r : rules_) {
                for (const std::vector<std::string>& alternative : r->right()) {
                    if (std::find(alternative.begin(), alternative.end(),
                                  symbol) != alternative.end())
                    {
                        *it++ = r;
                    }
                }
            }
            return it;
        }

        // Get the subject of the start symbol
        const std::string& get_start_left() const
        {
            return rules_.front()->left();
        }

        // Is this symbol the left (subject) of a terminal?
        bool symbol_is_left_of_terminal(const std::string& symbol) const
        {
            for (rule::const_ptr r : rules_) {
                if (r->left() == symbol) {
                    for (const std::vector<std::string>& alternative : r->right()) {
                        if (alternative.size() == 1 && symbol_is_terminal(alternative[0])) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        // Pretty-print
        friend std::ostream& operator <<(std::ostream& os, const grammar& gram)
        {
            for (rule::const_ptr r : gram.rules_) {
                os << *r;
                os << '\n';
            }
            return os;
        }

    private:
        std::vector<rule::ptr> rules_;
        std::vector<rule::ptr> start_rules_;
        std::vector<std::string> terminals_;
    };

} // namespace MB


#endif //UNTITLED2_GRAMMAR_H
