//
// Created by vm on 04.11.17.
//

#include <vector>
#include <iomanip>
#include "HashBloomFilter.h"

HashBloomFilter::HashBloomFilter(const std::string &fileName, int iterations, const std::string &urlFilePAth)
        : Algorithm(fileName, iterations), urlFilePAth(urlFilePAth) {}


bloom_filter instantiateBloomfilter(std::vector<std::string> urls) {
    bloom_parameters parameters;
    // How many elements roughly do we expect to insert?
    //parameters.projected_element_count = 1000;
    parameters.projected_element_count = urls.size();

    // Maximum tolerable false positive probability? (0,1)
    parameters.false_positive_probability = 0.0001; // 1 in 10000

    // Simple randomizer (optional)
    parameters.random_seed = 0xA5A5A5A5;

    if (!parameters)
    {
        std::cout << "Error - Invalid set of bloom filter parameters!" << std::endl;
        //return NULL;
    }

    parameters.compute_optimal_parameters();

    //Instantiate Bloom Filter
    bloom_filter filter(parameters);
    //Insert into Bloom Filter
   {
      // Insert some strings
      for (std::size_t i = 0; i < urls.size(); ++i)
      {
         filter.insert(urls[i]);
      }

//      // Insert some numbers
//      for (std::size_t i = 0; i < 100; ++i)
//      {
//         filter.insert(i);
//      }
   }
    return filter;
//
}

bool isNewLine(char c) {
    switch(c) {
        case '\r':
            return true;
        case '\n':
            return true;
        default:
            return false;
    }
}

void HashBloomFilter::prepareTestData() {
    std::vector<std::string> urls;

    std::ifstream reader;
    std::cout << urlFilePAth << std::endl;
    reader.open(urlFilePAth);
    if (!reader.is_open()) {
        std::cerr << "Could not open input file\n";
        return;
    }
//    int ctr = 1;
    for( std::string line; getline(reader, line);)
    {
//        std::cout << line << std::endl;
//        line.erase(line.begin(), line.end(), '\r');
        line.erase(std::remove_if(line.begin(), line.end(), &isNewLine), line.end());
        urls.push_back(line);
//        if(ctr %100 == 0)
//            str_list.push_back(line);
//        ctr++;
    }
    reader.close();

    bf = instantiateBloomfilter(urls);
    std::cout <<"\r\n rozmiar: " << bf.element_count() << std::endl;
    urls.shrink_to_fit();

    std::string list[] = {
            "http://www.brothersoft.com/",
            "http://www.domaintools.com/",
            "http://www.duowan.com/",
            "http://www.teacup.com/",
            "http://www.people.com/",
            "http://www.limewire.com/",
            "http://www.xrea.com/",
            "http://www.tgbus.com/",
            "http://www.kijiji.ca/",
            "http://www.0746news.com",
            "http://www.4223.com",
            "http://www.acls.jp",
            "http://www.ahlalhdeeth.com",
            "http://www.alpine.su",
            "http://www.antiekvalentijn.com",
            "http://www.areaconnect.com",
            "http://www.ausmena.lv",
            "http://www.badapps.fr",
            "http://www.beeec.net",
            "http://www.bikesell.co.kr",
            "http://www.bokus.com",
            "http://www.bttiantang.com",
            "http://www.camping-and-co.com",
            "http://www.cc2.co.jp",
            "http://www.chiefaircraft.com",
            "http://www.clipart.com",
            "http://www.connectingdirectors.com",
            "http://www.crimestoppersinlandnorthwest.org",
            "http://www.dathost.net",
            "http://www.detskie-igry.com",
            "http://www.dlgimmigration.com",
            "http://www.drhurd.com",
            "http://www.ecig.com",
            "http://www.elnauta.net",
            "http://www.espagencia.es",
            "http://www.fagakifood.gr",
            "http://www.filesend.to",
            "http://www.fmqu.com",
            "http://www.frisondeprat.fr",
            "http://www.gearbest.com",
            "http://www.glyde.com",
            "http://www.gore-tex.com",
            "http://www.hainan.net",
            "http://www.henryrifles.com",
            "http://www.houseplantsexpert.com",
            "http://www.ifanr.com",
            "http://www.indiquehair.com",
            "http://www.isvrostock.de",
            "http://www.jocpr.com",
            "http://www.kennedyexecutive.com",
            "http://www.kshowonline.com",
            "http://www.legabasket.it",
            "http://www.livecellresearch.com",
            "http://www.mackintosh-philosophy.com",
            "http://www.marinasailing.com",
            "http://www.medical-marijuana-shop.dk",
            "http://www.miline.jp",
            "http://www.modelmanagement.com",
            "http://www.multipasko.pl",
            "http://www.mywonderfullife.com",
            "http://www.net.tf",
            "http://www.northwestfishingreports.com",
            "http://www.ohtuleht.ee",
            "http://www.originpc.com",
            "http://www.parkourone.com",
            "http://www.pharma-medicaments.com",
            "http://www.playyourcourt.com",
            "http://www.pregnant.sg",
            "http://www.publictheater.org",
            "http://www.ras.ru",
            "http://www.retter.tv",
            "http://www.rpg.net",
            "http://www.sandale-artisanale-gibert.com",
            "http://www.sdgift.net",
            "http://www.sharpusa.com",
            "http://www.sita.aero",
            "http://www.softlayer.com",
            "http://www.sql.ru",
            "http://www.studmedlib.ru",
            "http://www.systemvna.com",
            "http://www.teambition.com",
            "http://www.tgiwholesale.com",
            "http://www.theroncatering.fi",
            "http://www.topswim.net",
            "http://www.trybellaplex.com",
            "http://www.ukbouldering.com",
            "http://www.uspharmacist.com",
            "http://www.vinnarum.com",
            "http://www.w3schools.com",
            "http://www.whiskybase.com",
            "http://www.woody.in.ua",
            "http://www.yamaha.com",
            "http://www.zeromotorcycles.com",
            "http://www.pagineverdibonsai.it",
            "http://www.spordunyasi.com",
            "http://www.namakubitattoo.com",
            "http://www.sacredcentertattoo.com",
            "http://www.perryshairsalon.com",
            "http://www.teaguepilates.com",
            "http://www.hairbows.com",
            "http://www.perfumeworld.net",
            "http://www.rootsandsculpture.co.uk",
            "http://www.1life1body.com",
            "http://www.yanmar.ne.jp",
            "http://www.beautymag.net",
            "http://www.manicurepedicure.biz",
            "http://www.allinform.ru",
            "http://www.wordpedia.com",
            "http://www.risdmuseum.org",
            "http://www.alexandria.lib.va.us",
            "http://www.lili.org",
            "http://www.faronet.be",
            "http://www.museumboerhaave.nl",
            "http://www.mmdecin.cz",
            "http://www.neanderthal.de",
            "http://www.raremaps.ru",
            "http://www.shipwreckmuseum.com",
            "http://www.wellnesstour.cz",
            "http://www.assodidatticamuseale.it",
            "http://www.sneznik.cz",
            "http://www.terraitaly.it",
            "http://www.krippenmuseum.com",
            "http://www.botelalbatros.cz",
            "http://www.poetry-archive.com",
            "http://www.cafardcosmique.com",
            "http://www.neuroticpoets.com",
            "http://www.eclectica.org",
            "http://www.victor-hugo.info",
            "http://www.jeandebonnot.fr",
            "http://www.indeath.net",
            "http://www.astronomytower.org",
            "http://www.lovelib.com.ua",
            "http://www.liebremarzo.com",
            "http://www.suomentolkienseura.fi",
            "http://www.elizabethmolin.com",
            "http://www.gedichte2000.de",
            "http://www.pottersarmy.net",
            "http://www.detective-fiction.com",
            "http://www.anastasia.sk",
            "http://www.siirdiyari.tripod.com",
            "http://www.yellapalooza.com",
            "http://www.skepticalscience.com",
            "http://www.socialworkers.org",
            "http://www.chemistry-chemists.com",
            "http://www.edie.net",
            "http://www.premierbiosoft.com",
            "http://www.falkoping.se",
            "http://www.populationdata.net",
            "http://www.raptorresource.org",
            "http://www.urbanecologycenter.org",
            "http://www.nmc.lt",
            "http://www.kemin.com",
            "http://www.mathsoc.jp",
            "http://www.aldevron.com",
            "http://www.deutscherimkerbund.de",
            "http://www.evolution-mensch.de",
            "http://www.northern-stars.com",
            "http://www.lenr-canr.org",
            "http://www.acris-antibodies.com",
            "http://www.kerala.gov.in",
            "http://www.istanbulbarosu.org.tr",
            "http://www.auf.org",
            "http://www.dentoncounty.com",
            "http://www.todaysmilitary.com",
            "http://www.perkinscoie.com",
            "http://www.provo.org",
            "http://www.mfin.hr",
            "http://www.sheppardmullin.com",
            "http://www.lss.bc.ca",
            "http://www.amherstma.gov",
            "http://www.cga.gov.tw",
            "http://www.paulding.gov",
            "http://www.elcato.org",
            "http://www.passaiccountynj.org",
            "http://www.diap.org.br",
            "http://www.intermin.fi",
            "http://www.johnniewalker.com",
            "http://www.unos.com",
            "http://www.straightbourbon.com",
            "http://www.nandosperiperi.com",
            "http://www.ricette-calorie.com",
            "http://www.mammamia.ro",
            "http://www.hurxley.co.jp",
            "http://www.diningcity.com",
            "http://www.bluemesagrill.com",
            "http://www.vinsvaldeloire.fr",
            "http://www.porland.com.tr",
            "http://www.diningchicago.com",
            "http://www.baxters.com",
            "http://www.veggiediner.com",
            "http://www.yamatomfg.com",
            "http://www.pah.org.pl",
            "http://www.toldot.ru",
            "http://www.lochness.co.uk",
            "http://www.bethinking.org",
            "http://www.crossculturalsolutions.org",
            "http://www.268generation.com",
            "http://www.evergreen.ca",
            "http://www.caritas.es",
            "http://www.skihut.nl",
            "http://www.homilia.org",
            "http://www.kovzunov.com",
            "http://www.aaaauto.sk",
            "http://www.metanoauto.com",
            "http://www.lva-auto.fr",
            "http://www.wilwood.com",
            "http://www.vwdiesel.net",
            "http://www.schwacke.de",
            "http://www.roker.kiev.ua",
            "http://www.motowheels.com",
            "http://www.crxcommunity.com",
            "http://www.toyotabg.net",
            "http://www.ducati.com.au",
            "http://www.poradnikzdrowie.pl",
            "http://www.chestnet.org",
            "http://www.life-enhancement.com",
            "http://www.nutrition.gov",
            "http://www.pinnaclehealth.org",
            "http://www.wrha.mb.ca",
            "http://www.saludfemenina.com.ar",
            "http://www.tusiad.org.tr",
            "http://www.fitness.gov",
            "http://www.centrahealth.com",
            "http://www.affinityhealth.org",
            "http://www.gambro.com",
            "http://www.allergique.org",
            "http://www.pokermoscow.ru",
            "http://www.ipoker.com",
            "http://www.donkpedia.org",
            "http://www.eastcoastgamingcongress.com",
            "http://www.justlottery.com",
            "http://www.zx.nu",
            "http://www.norskpokermagasin.com",
            "http://www.moolotto.com",
            "http://www.poker-agenda.fr",
            "http://www.rotoworld.com",
            "http://www.gdeizaci.com",
            "http://www.worldofo.com",
            "http://www.mcdonalds.ch",
            "http://www.thestalkingdirectory.co.uk",
            "http://www.golftipsmag.com",
            "http://www.extremeskins.com",
            "http://www.soccerballworld.com",
            "http://www.active.lviv.ua",
            "http://www.elitetrack.com",
            "http://www.nauticexpo.it",
            "http://www.footballdiehards.com",
            "http://www.uimn.org",
            "http://www.bcbsok.com",
            "http://www.hiway.org",
            "http://www.trade-ideas.com",
            "http://www.theaureport.com",
            "http://www.gcfcu.org",
            "http://www.texasbankandtrust.com",
            "http://www.benchmark.com",
            "http://www.zotero.org",
            "http://www.gate2home.com",
            "http://www.dofactory.com",
            "http://www.packardbell.com",
            "http://www.pointgphone.com",
            "http://www.mountvernon.org",
            "http://www.massresort.com",
            "http://www.france-pittoresque.com",
            "http://www.bridgeclimb.com",
            "http://www.np360.com.hk",
            "http://www.modelo-carta.com",
            "http://www.biska.com"
    };
    int size = (sizeof(list)) / sizeof(std::string);
    for (int i = 0; i < size; ++i) {
        str_list.push_back(list[i]);
    }
}

void HashBloomFilter::startTimeTest() {
    prepareTestData();
    prepareFileWriter();
//    std::string str_list[] = {
//            "http://www.agh.edu.pl/",
//            "http://upel.agh.edu.pl/",
//            "http://ai.ia.agh.edu.pl/wiki/pl:dydaktyka:unix:start#wyklady",
//            "http://www.bg.agh.edu.pl/",
//            "http://www.onet.pl/",
//            "http://www.wp.pl/",
//            "http://www.interia.pl/",
//            "http://www.rp.pl/",
//            "http://www.tvp.pl/",
//            "http://www.tvn24.pl/",
//            "http://www.pcworld.pl/",
//            "http://www.otomoto.pl/",
//            "http://www.otodom.pl/",
//            "http://www.librus.pl/",
//            "http://www.stackoverflow.com/",
//            "http://www.allegro.pl/",
//            "http://www.ferrari.com",
//    };
    int size = (sizeof(str_list)) / sizeof(std::string);
    std::fstream fs = prepareFileWriter();
    for (int j = 0; j < iterations; ++j) {

        auto start = std::chrono::high_resolution_clock::now();
        for (int i = 0; i < str_list.size(); ++i)
        {
            bool x = bf.contains(str_list[i]);
//            if (x) {
//                std::cout << "BF falsely contains: " << str_list[i] << std::endl;
//            }
        }
        diff = std::chrono::high_resolution_clock::now() - start;
        fs << std::setprecision(0) << std::fixed << diff.count() * 1000000000 << std::endl;
        std::cout << j << " " << str_list.size() << std::endl;
    }
    fs.close();
}
