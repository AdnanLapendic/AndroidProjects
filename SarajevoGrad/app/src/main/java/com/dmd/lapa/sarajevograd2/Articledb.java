package com.dmd.lapa.sarajevograd2;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lapa on 9/20/16.
 */

public class Articledb {

    public Articledb(){

    }

    public static ArrayList<Article> articles = new ArrayList<>();
    public static ArrayList<Article> articlesBih = new ArrayList<>();
    public static ArrayList<Article> articlesRegija = new ArrayList<>();
    public static ArrayList<Article> articlesSvijet = new ArrayList<>();
    public static ArrayList<Article> articlesSport = new ArrayList<>();
    public static ArrayList<Article> articlesZanimljivosti = new ArrayList<>();
    public static ArrayList<Article> articlesScitech = new ArrayList<>();

    public static void populateDb(){
        articles.add(new Article(1, "Kolegij Narodne skupštine danas o zabrani referenduma u RS-u", "U taj zakonodavni dom dostavljena je odluka Ustavnog suda BiH o privremenoj mjeri zabrane referenduma, koji je, nakon glasanja u parlamentu RS zakazan za 25. septembar.\n" +
                "\n" +
                "U Narodnu skupštinu RS dostavljeni su i zaključci Ustavnog suda BiH, usvojeni na sjednici 17. septembra.\n" +
                "\n" +
                "Kolegij Narodne skupštine RS razmatrat će i orijentacioni plan rada parlamenta do kraja 2016. godine.\n" +
                "\n" +
                "Ustavni sud BiH potvrdio je 17. septembra svoju raniju odluku o neustavnosti 9. januara kao Dana RS te privremenom mjerom zabranio referendum u RS-u najavljen za 25. septembar, ali su srpski političari naveli da ostaju pri skupštinskoj odluci da se referendum provede.", "BiH", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160921002.jpg"));
        articles.add(new Article(2,"Hrvatska: Ukinuli ulicu Franje Tuđmana jer je \"pljačkom osiromašio narod\"\n", "Hrvatski grad Primošten nakon 12 godina više nema ulicu dr. Franje Tuđmana. Glasovima vladajuće Nezavisne liste načelnika Stipe Petrine, ulica na atraktivnoj lokaciji usred Primoštena preimenovana je u historijski toponim Mala Raduča.\n Protiv su bila dva HDZ-ova vijećnika, dok je vijećnik HNS-a bio suzdržan. Oduzimanje ulice izazvalo je zgražanje vijećnika HDZ-a dr. Marija Jurina.\n" +
                "\n" +
                "\"Radi se o nerazumnom činu jer je Tuđman najveća historijska ličnost u proteklih nekoliko stoljeća\", smatra dr. Jurin.\n" +
                "\n" +
                "\"Tuđman je privatizacijskom pljačkom osiromašio hrvatski narod i nanio mu najveću štetu. Pokrenite zakonski postupak, pa možda Tuđman ponovno dobije svoju ulicu\", odgovorio je Petrina, prenosi Slobodna Dalmacija.", "Regija", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160920061.jpg?v=1"));
        articles.add(new Article(3, "Obama: Moramo otvoriti srca i više pomoći izbjeglicama", " Američki predsjednik Barack Obama objavio je pred Generalnom skupštinom Ujedinjenih nacija (UN) da se 50 zemalja obavezalo da primi još 360.000 izbjeglica, kao i da će Sjedinjene Američke Države (SAD) primiti još 110.000 izbjeglica od početka sljedeće fiskalne godine, piše BBC.\n" +
                "Do kraja septembra, koji predstavlja kraj fiskalne 2016. godine, SAD će primiti 85.000 izbjeglica. Taj broj će se povećati za desetine hiljada sljedeće godine.\n" +
                "\n" +
                "Obama je iskoristio svoje posljednje obraćanje u UN-u da govori o izbjegličkoj krizi.\n" +
                "\n" +
                "\"Sada zajedno moramo otvoriti srca i učiniti više da pomognemo izbjeglicama koje su očajne da imaju dom\", rekao je.\n" +
                "\n" +
                "Iako nije direktno spomenuo SAD, Obama je rekao da bogatije zemlje sa resursima trebaju pomoći više.\n" +
                "\n" +
                "\"Svijet je premali za nas da jednostavno možemo sagraditi zid i spriječiti ekstremizam da utječe na naša društva\", rekao je on, aludirajući na plan republikanskog kandidata Donalda Trumpa da podigne zid na granici sa Meksikom.\n" +
                "\n" +
                "Nekoliko sati ranije generalni sekretar UN-a Ban Ki-moon je također izrazio brigu u vezi s konfliktom u Siriji, rekavši da ne postoji vojno rješenje.", "Svijet", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160921007.jpg?v=1"));
        articles.add(new Article(4, "Matthaus: Messi je Maradona modernog doba\n", "Zvijezda Barcelone i argentinske reprezentacije Lionel Messi je as kao što je u svoje vrijeme bio njegov sunarodnjak Diego Maradona, izjavio je njemački fudbalski stručnjak Lothar Matthaus. \n" +
                "Pedesetpetogodišnjak koji je u dresu Njemačke protiv Argentine igrao na svjetskim prvenstvima 1986. i 1990. godine ima samo riječi hvale za Messija. U razgovoru o najboljim fudbalerima svijeta uporedio ga je s Maradonom i Brazilcem Peleom.\n" +
                "\n" +
                "\"Messi je sada ono što je Maradona bio prije 30 godina\", istakao je u izjavi za Fox Sports.\n" +
                "\n" +
                "Matthaus i Maradona su imali brojne okršaje, uključujući finala svjetskih prvenstava 1986. i 1990. godine.\n" +
                "\n" +
                "\"Kada govorim o Meksiku '86., skratit ću i samo reći: Maradona. Nikad nisam vidio igrača koji toliko dominira svjetskim prvenstvom kao što je on to činio 1986. godine\", izjavio je.", "Sport", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160921053.jpg?v=1"));
        articles.add(new Article(5, "iPhone 7 u BiH dolazi 23. septembra, narudžba moguća sljedećeg petka", "Već 16. septembra novi iPhone 7 ii iPhone 7 Plus građani BiH će moći naručiti u ovlaštenim prodavnicama, a iste kupiti već sedam dana kasnije.\n" +
                "\n" +
                "U Sjedinjenim Američkim Državama narudžbe za nove pametne telefone počele su 9. septembra, a u prodaju će biti pušteni 16. septembra. Najmanja cijena novog uređaja bit će 649 dolara, a bit će dostupna u tri varijante zavisno od količine interne memorije - 32 GB, 128 GB i 256 GB.\n" +
                "\n" +
                "Prva karakteristika novog pametnog telefona jeste bolja kamera, displej Retina HD je 25 posto svjetliji od prethodnika, uređaji su obogaćeni su stereo zvučnicima, a uklonjen je i 3,5-milimetarski utor.\n" +
                "\n" +
                "Uređaje će pokretati procesor A10 Fusion - riječ je o 64-bitnom četverojezgrenom čipu koji je 120 puta brži od originalnog iPhonea i dvostruko brži od procesora A8. Novi grafički čip brži je 240 puta od originalnog iPhonea i predstavlja najbrži grafički procesor na nekom pametnom telefonu.\n" +
                "\n" +
                "Baterija je navodno dugotrajnija od one u iPhoneu 6S za 120 minuta.", "Scitech", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160909097.jpg?v=1"));
        articles.add(new Article(6, "Sutra u Sarajevu Vlastopol: Srednje visoki predstavnik sa Kirbom, Milijem, Cvijom, Graditeljem...", "Ekipa satiričnog portala karakter.ba pridružuje se predizbornoj kampanji i najavljuje svoje posjete u tri stolna grada Bosne i Hercegovine, za svaki narod po jedan grad.\n" +
                "U ponedjeljak, 26. septembra, od 12:30 ispred BBI Centra u Sarajevu ćete moći čuti obećanja, za šta služi vitalni nacionalni interes, kako izbjeći zatvor, ali i povećanje penzija te kako koalirati sa svima u ovoj jedinstvenoj satirično-humorističnoj predstavi.\n" +
                "\n" +
                "\"Vlastopol je jedna ploča sa 28 polja, jedna kocka za šest super moćnih igrača i jedan srednje visoki predstavnik da vlada svima. Vlastopol – igra za mlade i stare, lijeve i desne, zelene i crvene, plave i roze - jednoroge! Ovog septembra u tri velika bh. grada, a do kraja godine u svakom ozbiljnijem domaćinstvu. Igra u kojoj svi učestvuju, ali rijetki je igraju\", izjavio je srednje visoki predstavnik čiji zadatak će biti da režira igru i nadgleda poteze ostalih igrača, a ostali igrači su: Kirba, Dr. Agan, Mili Predsjednik, Cvija, Graditelj i svima omiljeni Susjedić.\n" +
                "\n" +
                "Ako vam njihova imena nisu poznata, pročitajte ih ponovo, ali ovaj put i malo razmislite.\n" +
                "\n" +
                "Srednje visoki predstavnik se brine o tome da svi igrači poštuju striktna i logički koncipirana pravila. Katkad će im progledati kroz prste, drugi put ih pacnuti po prstima, ali naš srednje visoki predstavnik će svako kršenje pravila najoštrije osuditi, ako treba i pismenim putem. Pred njim drhte svi pa čak i on sam, najčešće ujutro dok ne popije prvu lozu.\n" +
                "\n" +
                "Demonstracija igre, sile, moći i još nekoliko riječi koje dobro zvuče u predizbornoj kampanji održat će se, osim u Sarajevu još i u Banjoj Luci, 28. septembra, u parku Petar Kočić, i u Mostaru, 30. septembra, na Španskom trgu.\n" +
                "\n" +
                "Ovim putem karakter.ba poziva sve zainteresirane da se pojave na pobrojanim mjestima, uživaju u igri i odaberu svoje favorite.\n", "Zanimljivosti", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160923075.jpg?v=2"));
        articles.add(new Article(7, "Izetbegović u New Yorku s ministrom vanjskih poslova Velike Britanije Johnsonom\n", "Predsjedavajući Predsjedništva BiH Bakir Izetbegović sastao se u New Yorku s ministrom vanjskih poslova Velike Britanije Borisom Johnsonom.\n" +
                "Britanski šef diplomatije je izrazio zadovoljstvo ostvarenim napretkom Bosne i Hercegovine na putu ka Evropskoj uniji, te sprovedenim reformama. Uputio je čestitke predsjedavajućem PBiH Izetbegoviću zbog prihvatanja aplikacije BiH za članstvo u Evropskoj uniji.\n" +
                "\n" +
                "Ministar Johnson je naglasio spremnost Velike Britanije da i ubuduće pruži punu podršku Bosni i Hercegovini u procesu integracije u EU i NATO.\n" +
                "\n" +
                "Tokom susreta razgovarano je o aktuelnoj političkoj situaciji u BiH i regiji, te je istaknut značaj stabilnosti i integracionih procesa.", "BiH", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160921021.jpg?v=1"));
        articles.add(new Article(8, "Beograd: Sve spremno za Gay Pride, na ulicama jake policijske snage", "Tačno u podne na ulicama glavnog grada Srbije održat će se beogradska Parada ponosa 2016. Centralne beogradske ulice kojom će proći kolona već su zatvorene. Na ulicama je veliki broj pripadnika žandarmerije i policajaca. U šetnji će, prema ranijim najavama, učestvovati oko 1.500 ljudi. \n" +
                "Paradu će pratiti više od 400 novinara iz zemlje i inostranstva, a među šetačima i ove godine će biti i ambasador Evropske unije u Srbiji. Gay Pride će osiguravati manje policije u odnosu na ranije godine, piše Blic.rs.\n" +
                "\n" +
                "\"Očekujemo isti ili veći broj ljudi na Paradi, od 1.300 do 1.500. Broj ljudi je važan, ali nije presudan jer se veliki broj ljudi koji su dio LGBT zajednice još plaši da bude viđen\", rekao je Boban Stojanović, jedan od organizatora.\n" +
                "\n" +
                "Učešće na Paradi ponosa najavila je ministrica za državnu upravu i lokalnu samoupravu Ana Brnabić, a ministrica bez portfelja Slavica Djukić Dejanović rekla je da će prisustvovati Paradi ponosa ukoliko joj to obaveze dozvole, a za Tanjug je rekla da podržava Paradu ponosa.\n" +
                "\n" +
                "Prva Parada ponosa organizovana je 2001. godine, kada je učesnike pretukla grupa huligana i pristalica desničarskih organizacija, a od tada do danas iz sigurnosnih razloga nadležni su je otkazivali tri puta - 2011, 2012. i 2013. godine.\n" +
                "\n" +
                "Parada ponosa je planirana 2004. godine, ali su je organizatori otkazali nakon martovskih nemira na KiM i paljenja džamija u Nišu i Beogradu.\n" +
                "\n" +
                "Naredna je bila zakazana 2009. godine, ali je otkazana, jer organizatori nisu željeli da prihvate preporuke MUP-a da se manifestacija održi na drugoj, sigurnijoj lokaciji. Parada ponosa održana je 2010, 2014. i 2015. godine.", "Regija", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/160918021.3_mn.jpg"));
        articles.add(new Article(9, "SAD optužile Rusiju za napad na konvoj humanitarne pomoći u blizini Alepa", " \n" +
                "Sjedinjene Američke Države saopćile su kako smatraju da je Rusija odgovorna za smrtonosni napad na konvoj humanitarne pomoći koji se dogodio u blizini sirijskog grada Alepa.\n" +
                "Bijela kuća opisala je ovaj događaj kao \"ogromnu humanitarnu tragediju\", a američki zvaničnici su rekli za BBC kako su dva ruska ratna aviona kriva za napad.\n" +
                "\n" +
                "Rusija odlučno negira učešće u ovom incidentu te ističe kako je uzrok tragedije požar na zemlji, a ne napad iz zraka.\n" +
                "\n" +
                "\"Nema kratera i na vanjskom dijelu vozila nema štete koja je povezana s eksplozijom koju bi uzrokovale bombe bačene iz zraka\", navodi se u izjavi Ministarstva odbrane Rusije.\n" +
                "\n" +
                "Ipak, američki službenici tvrde da je napad bio vrlo sofisticiran i da ga sirijske snage nisu mogle izvesti.\n" +
                "\n" +
                "\"Za ovo mogu biti odgovorne samo dvije strane ili sirijski režim ili ruska vlada. U svakom slučaju smatramo da je ruska vlada kriva za zračne napade u ovom dijelu\", rekao je glasnogovornik Bijele kuće Ben Rhodes.\n" +
                "\n" +
                "U napadu je uništeno 18 od 31 kamiona, a ubijeno je 20 civila među kojima je i šef Crvenog polumjeseca. Zbog napada je UN suspendovao sve konvoje humanitarne pomoći Sirije.\n" +
                "\n" +
                "Vijeće sigurnosti UN-a održat će sastanak na visokom nivou o Siriji danas, a zvaničnici će se sastati u petak.\n" +
                "\n" +
                "Humanitarna pomoć koju su prevozili konvoji bila je ključna za ljude koji žive u opkoljenim gradovima, a koji su ostali bez hrane. higijenskih potrepština i lijekova.\n" +
                "\n" +
                "Predsjednik Komiteta Crvenog križa Peter Maurer rekao je kako je napad grubo kršenje međunarodnog humanitarnog prava i da se može smatrati ratnim zločinom.", "Svijet", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160921006.jpg?v=1"));
        articles.add(new Article(10, "Sedam mečeva odigrano trećeg dana turnira S.ketch Street Basketball 2016\n", "Trećeg takmičarskog dana S.ketch Street Basketball 2016 turnira u “uličnoj košarci“ za osnovce i srednjoškolce odigrano je sedam mečeva. \n" +
                "Na turniru učestvuju 59 ekipe (236 školaraca) u tri konkurencije: do 9. razreda osnovne škole, do 2. razreda srednje škole, i do 4. razreda srednje škole.\n" +
                "\n" +
                "Postignuti su slijedeći rezultati:\n" +
                "\n" +
                "Do 2. razreda srednje škole\n" +
                "OSMINA FINALA: Treća gimnazija (kap. Bajramović) - Prva gimnazija (kap. Hajdarević) 3:4, Druga gimnazija (kap. Begić) - Srednja tehnička škola GTDM (kap. Adžić) 7:6\n" +
                "ČETVRTFINALA: Treća gimnazija (kap. Panjeta) - Srednja ekonomska škola (kap. Velić) 11:8, Internacionalna srednja škola (kap. Gutić) - Gimnazija Obala 2 11:0, Treća gimnazija (kap. Kukuruzović) - Prva gimnazija (kap. Hajdarević) 2:3, Gimnazija Obala 3 - Druga gimnazija (kap. Begić) 4:10\n" +
                "\n" +
                "Do 4. razreda srednje škole\n" +
                "ČETVRTFINALE: Elektrotehnička skola za energetiku (kap. Tihić) - Druga gimnazija (kap. Sarić) 5:9\n" +
                "\n" +
                "Takmičenje se nastavlja u utorak, 20.09.2016. od 15 sati. Detaljan raspored mečeva možete preuzeti na Facebooku.\n" +
                "\n" +
                "Podsjećamo da će se finalni mečevi u sve tri konkurencije odigrati u srijedu, 21.09.2016. godine od 16:00 sati.\n" +
                "\n" +
                "Dječija sportska škola \"Proacademia\" i marketing agencija \"B40\", šestu godinu zaredom organizuju projekat S.ketch Street Basketball, turnir u “uličnoj košarci” za osnovce i srednjoškolce, a od prošle godine pored Sarajeva, osnovci i srednjoškolci će se takmičiti i u Banjoj Luci (24.-28.09.2016.) i Mostaru (01.-05.10.2016.).\n" +
                "\n" +
                "Najbolje ekipe u sve tri konkurencije i ove godine će osvojiti vrijedne nagrade, koje su pripremili Sportlife, Argeta, Sky Cola i Konzum.\n" +
                "\n" +
                "Tokom svih pet dana takmičenja biće postavljen i dječiji košarkaški teren, tako da će i oni najmlađi imati priliku da se zabave na platou BBI Centra. Za dobro raspoloženje, uz kvalitetnu muziku i simpatične komentare, i ove godine brinuće se DJ Nane.\n" +
                "\n" +
                "Projekat podržali: Happy, Argeta, Konzum, Sky Cola, Privredna banka Sarajevo, Adidas, BBI Centar, Sportlife i Railcargo logistics.\n" +
                "\n" +
                "Medijski pokrovitelji: Klix.ba, Oslobođenje, RSG radio, SCsport.ba, Antena Sarajevo, i Face TV.", "Sport", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160920070.jpg?v=1"));
        articles.add(new Article(11, "Službeni opoziv miliona Samsung Galaxy Note 7 telefona", "Sigurnosni regulatori Sjedinjenih Američkih Država (SAD) objavili su u četvrtak službeni opoziv telefona Samsung Galaxy Note 7 nakon serije požara koji su doveli do povreda i oštećenja imovine, uz veliku glavobolju za južnokorejskog tehnološkog giganta.\n" +
                "\"Kako ovaj proizvod predstavlja ozbiljnu opasnost od požara, pozivam sve kupce da ovaj opoziv odmah iskoriste\", rekao je Elliot Kaye, predsjednik Komisije potrošača za sigurnost proizvoda. \n" +
                "\n" +
                "Samsung je već započeo dobrovoljni opoziv, ali je ova kompanija kritikovana zbog toga što nisu dali jasne informacije o problemu ili kako da se riješi. Govoreći s novinarima, Kaye je kritikovao Samsung jer nisu sarađivali s njegovom agencijom.\n" +
                "\n" +
                "\"Obično nije recept za uspješan opoziv da kompanija radi sama\", rekao je on, dodajući da bilo ko ko vjeruje da je jednostran napor dovoljan treba provjeriti još nešto osim telefona. \n" +
                "\n" +
                "Samsung je rekao da problem uključuje blizu 2,5 miliona pametnih telefona u svijetu; vlasti kažu da ih je od toga blizu milion u Sjedinjenim Američkim Državama. Iako je kompanija ranije nudila zamjenu telefona, sada će ponuditi potrošačima izbor zamjene ili puni povrat novca.\n" +
                "\n" +
                "Opoziv dolazi u vrijeme kada je Samsung u velikoj bici sa kompanijom Apple za pažnju kupaca. Apple je upravo predstavio najnoviju verziju svog iPhonea koji ide u prodaju u petak.\n" +
                "\n" +
                "Samsung je uspio predstaviti Galaxy Note 7 nekoliko sedmica prije Appleovog predstavljanja. Telefon je dobijao dobre kritike, a u SAD-u je imao početnu cijenu od 850 američkih dolara. Međutim, kupci su počeli prijavljivati probleme s pregrijavanjem baterije, što ponekad dovodi do požara ili eksplozija. \n" +
                "\n" +
                "Jedna porodica u St. Petersburgu, Florida, rekla je da je ostavila Galaxy Note 7 da se puni u njihovom automobilu marke Jeep te da je telefon uzrokovao požar koji je uništio vozilo. \n" +
                "\n" +
                "Samsung je dobio 92 prijave pregrijavanja baterije, uključujući 26 prijava opekotina i 55 oštećenja imovine, prema podacima na web stranici Komisije. Rečeno je da oštećenje imovine uključuje požare u automobilima i garažama. \n" +
                "\n" +
                "U međuvremenu su službenici za sigurnost zrakoplovstva u SAD-u napravili neobičan korak davanja upozorenja putnicima da ne uključuju ili pune telefone tokom letova, kao i da ih ne stavljaju u prtljag.\n" +
                "\n" +
                "Službenik Samsunga se u četvrtak izvinio kupcima i obećao da će ubrzati povlačenje. \n" +
                "\n" +
                "\"Nismo zadovoljili standard izvrsnosti koji očekujete i zaslužujete\", rekao je Tim Baxter, predsjednik Samsung Electronics America, u videu koji je objavila kompanija. \n" +
                "\n" +
                "Kritičari kažu da Samsung nije poštovao pravila komisije koja pozivaju kompanije da koordiniraju povlačenje proizvoda s komisijom, uključujući i zajedničko saopćenje za javnost, iako je Baxter u četvrtak izjavio da je njegova kompanija obavijestila komisiju prije nego što je najavila da će prestati prodavati Note 7 2. septembra.\n" +
                "\n" +
                "Samsung je tada najavio da će zamijeniti bilo koji Note 7 koji je prodao, a rok za zamjenu je sedam dana. Ali u saopćenju za javnost koje su izdali potrošačima nij rečeno da prestanu koristiti uređaj.\n" +
                "\n" +
                "Sedmicu poslije, kompanija i komisija su izdale različita saopćenja kojima su pozvale potrošače da prestanu koristiti Note 7. Tada je Samsung rekao da će ponuditi zamjenske Note 7 uređaje nakon što ih komisija odobri. \n" +
                "\n" +
                "Samsungove izjave ostavile su mnoge kupce zbunjenim, rekao je Tuong Nguyen, analitičar tehnološke industrije u Gartneru, te dodao da bi to moglo utjecati na ukupno povjerenje kupaca.\n" +
                "\n" +
                "Ljudi koji su kupili telefon to su učinili kako bi dobili najbolji mogući kvalitet i usluge, rekao je Nguyen, dodajući da je način ovog opoziva bio promašaj.\n" +
                "\n" +
                "Kupci Note 7 telefona koji ne žele povrat novca mogu odabrati da uzmu novi Note 7 telefon, za koji kompanija kaže da će biti dostupan u SAD-u do srijede, ili manji i jeftiniji Galaxy S7 ili S7 Edge odmah, uz povrat razlike u cijeni. \n" +
                "\n" +
                "Blizu 97 posto telefona prodatih u SAD-u se opoziva.", "Scitech", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160916008.jpg?v=1"));
        articles.add(new Article(12, "Bush prekinuo Obamu u razgovoru i zatražio da ga fotografiše", "Predsjednik SAD-a ima brojne obaveze i odgovornosti, pa se tako pojavljuje i na brojnim kulturnim događajima, ali i rješava ozbiljne probleme. Barack Obama je ovaj put zamoljen da učini nešto sasvim neuobičajeno - da fotografiše.\n" +
                "Bivši predsjednik SAD-a George W. Bush prekinuo je sadašnjeg predsjednika Obamu na ceremoniji otvorenja Muzeja afričko-američke kulture u Washingtonu u njegovom razgovoru i zatražio da ga fotografiše s gostima.\n" +
                "\n" +
                "Obama se pozdravljao s nekim kada ga je Bush dotaknuo po ramenu i pitao ga da ih fotografiše. Predsjednik se uopće nije bunio, što je ispalo vrlo simpatično.\n" +
                "\n" +
                "President Bush tapping President Obama to take a picture #NMAAHC pic.twitter.com/Z7KbOMIOWr\n" +
                "\n" +
                "— NancyA (@npa222) September 24, 2016\n" +
                "\n" +
                "\n" +
                "\n" +
                "Inače, Bush i Obama su se družili tokom jučerašnje ceremonije, a prva dama Michelle je čak i srdačno grlila Busha nakon službenog dijela.", "Zanimljivosti", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160925010.jpg?v=1"));
        articles.add(new Article(13, "U Jablanici se otvara novoizgrađena sportska dvorana sa oko 2.000 mjesta", "Svečano otvaranje novoizgrađene sportske dvorane u Jablanici zakazano je za petak u 18 sati.\n" +
                "Vrijednost radova na projektu iznosi nešto više od 6.000.000 KM. Do sada je u potpunosti izgrađen sportski dio objekta. Kapacitet dvorane je oko 2.000 mjesta (sa teleskopskim tribinama), a objekat raspolaže i salom sa fitnes, terenom za borilačke sportove te modernim svlačionicama za sportiste, sudije i prostorijama za službene osobe, parketom površine više od 1.500 m² i opremom usklađenim po najvišim međunarodnim standardima, tako da se u njoj mogu odigravati međunarodne rukometne, košarkaške, odbojkaške i futsal utakmice.\n" +
                "\n" +
                "Objekat sportska dvorana raspolaže sa osvjetljenom podzemnom garažom sa više parking mjesta te otvorenim parking mjestima oko dvorane.\n" +
                "\n" +
                "U okviru svečanosti kojoj će prisustvovati brojne ugledne zvanice federalnog, kantonalnog i lokalnog nivoa, te predstavnici javnog, društvenog, privrednog i vjerskog života općine Jablanica i HNK, te susjednih općina, sportskih radnika i klubova predviđen je, uz prigodna obraćanja, bogat kulturno-umjetnički i sportski program. Nakon svečanog otvorenja dvorane predviđeno je održavanje košarkaške utakmice između KK Turbina Jablanica i bivšeg prvaka Evrope u košarci KK Bosna Royal Jelly iz Sarajeva. ", "BiH", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160921058.jpg?v=1"));
        articles.add(new Article(14, "Crna Gora: Dječaci od osam i deset godina nožem izboli 71-godišnjeg starca", "Osmogodišnji dječak čiji su inicijali Z. R. i desetogodišnji H. B. uhapšeni su u Tuzima, nedaleko od Podgorice, zbog sumnje da su nožem teško povrijedili sedamdesetjednogodišnjeg B. B.\n Kako je saopštila crnogorska policija, incident se desio oko 13 sati u Tuzima, nadomak Podgorice, kada su se dječaci posvađali sa starcem, a potom ga i dva puta uboli nožem sa leđa, prenosi Blic.\n" +
                "\n" +
                "Povrijeđeni starac je u teškom stanju prebačen u Klinički centar u Podgorici, gdje se ljekari bore za njegov život.", "Regija", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160919138.jpg"));
        articles.add(new Article(15, "Erdogan pozvao svjetske lidere da preduzmu mjere protiv Gulena", "Turski predsjednik Recep Tayyip Erdogan danas je pozvao svjetske lidere u UN da preduzmu mjere protiv \"terorističke mreže\" Fetullaha Gulena koji živi u SAD-u i koja, kako je kazao, ugrožava i njihovu sigurnost. \n" +
                "\"Pozivam sa ove govornice sve naše prijatelje da brzo preduzmu neophodne mjere protiv gulenističke terorističke organizacije zbog vlastite sigurnosti i budućnosti svojih nacija\", kazao je Erdogan, prenosi Al Jazeera Balkans.\n" +
                "\n" +
                "Turske vlasti su optužile Fetullaha Gulena da je orkestrirao neuspjeli puč u julu.\n" +
                "\n" +
                "Pozvavši na trenutno političko rješenje krize u Siriji, Erdogan je kazao da je Turska intervencija u sjevernoj Siriji početkom septembra dovela do uspostavljanja mira, ravnoteže i stabilnosti u regionu kojim je zavladalo beznađe.\n" +
                "\n" +
                "On je optužio Evropsku uniju da nije održala obećanje u vezi članstva Turske u EU, navodi Reuters.", "Svijet", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160920142.jpg?v=1"));
        articles.add(new Article(16, "Challenger Izmir: Bašić ušao u drugo kolo, moguć duel protiv Brkića\n","Mirza Bašić je u prvom kolu ATP Challengera u turskom Izmiru sa 2:1 savladao Nikolu Milojevića nakon dva sata i 28 minuta igre. "+
                "Prvi set je pripao srbijanskom teniseru nakon 48 minuta igre, a riješio ga je u svoju korist rezultatom 7:5.\n" +
                "\n" +
                "Bašić je potom u drugom setu zaigrao mnogo bolje i nakon samo 43 minute igre ga riješio u svoju korist sa 6:4 te odveo meč u odlučujući treći set.\n" +
                "\n" +
                "U trećem setu Milojević je imao priliku osvojiti meč kada je pri rezultatu 5:4 servirao za meč, no Bašić je uspio napraviti break i ostati u meču. Potom je bio siguran na svoj servis i pritisak je bio na 223. teniseru svijeta. Milojević je popustio pod pritiskom i Bašić je stigao do pobjede slavivši u trećem setu 7:5.\n" +
                "\n" +
                "U drugom kolu Bašić će igrati protiv pobjednika meča Tomislav Brkić - Kevin Griekspoor koji je u toku", "Sport", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160920075.jpg"));
        articles.add(new Article(17, "U Kini pušten u rad najveći radioteleskop na svijetu", "Najveći radioteleskop na svijetu pušten je u nedjelju u rad na jugozapadu Kine i trebao bi pomoći čovječanstvu u potrazi za vanzemaljskim životom.\n" +
                "Teleskop FAST dug 500 metara, postavljen među planinama brdovite regije Guizhou, počeo je s radom oko podne, objavila je agencija Xinhua.\n" +
                "\n" +
                "Izgrađen za 180 miliona dolara i s reflektorom veličine 30 nogometnih igrališta, teleskop je titulu najvećeg preuzeo od opservatorija Arecibo u Portoriku.\n" +
                "\n" +
                "FAST će istraživati svemir i tragati za znakovima inteligentnog života, navodi agencija.\n" +
                "\n" +
                "Kineski svemirski program vrijedan milijarde dolara i pod vojnom upravom trebao bi pokazati tehnološki napredak te zemlje.\n" +
                "\n" +
                "Peking do 2020. planira u svemiru postaviti trajnu orbitalnu stanicu i vjerovatno poslati ljudsku posadu na Mjesec.\n", "Scitech", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160925045.jpg?v=1"));
        articles.add(new Article(18, "Ryan Kavanaugh će snimiti film o poznatoj gorili Harambe ukoliko dobije milion retweetova", "Filmski producent i američki biznismen Ryan Kavanaugh prije sedam dana na Twitteru je objavio zanimljiv tweet napisavši kako će o poznatoj gorili Harambe snimiti film, ukoliko dobije miliona retweetova.\n" +
                "Njegov tweet je prošle sedmice dobio skoro četvrtinu miliona retweetova, a prema svemu sudeći, mnogo ljudi želi vidjeti film o gorili Harambe koja je upala u ograđeni prostor Zoološkog vrta u Cincinnatiju, a bojeći se za trogodišnjeg dječaka koji se u tom trenutku našao tu, čuvari zoološkog vrta su je ubili.\n" +
                "\n" +
                "1,000,000 retweets and I'll make a Harambe movie \uD83D\uDE48\uD83D\uDE4A\n" +
                "\n" +
                "— Ryan Kavanaugh (@RyanKavanaugh) September 16, 2016\n" +
                "\n" +
                "\n" +
                "\n" +
                "Inače, top deset postova koji su najviše retweetovani u 2015. godini su povezani s članovima One Directiona, predsjednikom Sjedinjenih Američkih Država (SAD) Barackom Obamom, Kanye Westom i kraljem Saudijske Arabije. \n" +
                "\n" +
                "Kavanaughova kompanije je do sada objavila desetine filmova, prije nego što je pala u tešku krizu, a onda se iz stečaja povukla u martu i ponovo pojačala svoju proizvodnju.\n", "Zanimljivosti", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160923118.jpg?v=1"));
        articles.add(new Article(19, "CCI: Zavodi za zapošljavanje u BiH služe jedino za pružanje besplatne zdravstvene zaštite\n", "\n" +
                "Prema njihovim izjavama i podacima, ZZO troši 150 miliona KM godišnje na pružanje zdravstvene zaštite osobama koje u ZZO imaju status nezaposlenih.\n" +
                "\n" +
                "Druga stvar koju radi ZZO jeste evidentiranje nezaposlenih prijavljenih u zavodu i ostvarivanje određenih prava u njihovo ime, rečeno je na današnjoj uličnoj akciji i promociji studije \"Reformska agenda i aktivne politike zapošljavanja: da li zavodi zavode ili zapošljavaju nezaposlene?\", koja je u organizaciji CCI-a održana u centru Sarajeva.\n" +
                "\n" +
                "\"Zavodi za zapošljavanje u Bosni i Hercegovini bi trebali vršiti ulogu posrednika na tržištu između ponude i potražnje. Kod nas postoji jedan paradoks: status zaposlenosti i nezaposlenosti povezan je s pravom na ostvarivanje zdravstvene zaštite iako po Ustavu BiH svaki građanin ove zemlje ima pravo na takav vid zaštite\", rekao je Ismar Hota iz CCI-a.\n" +
                "\n" +
                "Kada je u pitanju broj nezaposlenih u BiH, on varira od evidencijske stope koja iznosi 42-45 posto nezaposlenih, dok anketna evidencija pokazuje možda i realnu sliku nezaposlenih 23-27 posto u posljednjih pet godina.\n" +
                "\n" +
                "Anketna stopa nezaposlenosti je čak i realna slika stanja tržišta rada u BiH, a razliku između anketne i evidencijske stope predstavlja velika siva ekonomija. Mnogo ljudi radi nacrno, a i dalje su registrovani kao nezaposleni prijavljeni u zavodima za zapošljavanje\", dodaje Hota.\n" +
                "\n" +
                "On smatra da je jedan od razloga rada nacrno upravo to što osoba i dalje ostaje na evidenciji zavoda za zapošljavanje kao nezaposlena te na taj način nastavlja ostvarivati besplatnu zdravstvenu zaštitu.\n" +
                "\n" +
                "Postoje i oni koji uopće i ne traže posao te upravo zbog statusa nezaposlenosti i ostvarivanja zdravstvene zaštite ostaju prijavljeni na zavodima.\n" +
                "\n" +
                "Hota dodaje i kako se blizu 20 posto budžeta zavoda troši na aktivnu politiku zapošljavanja koja bi i trebala predstavljati osnovnu politiku ovih zavoda", "BiH", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/160921054.5_xl.jpg"));
        articles.add(new Article(20, "Zemljotres u Makedoniji: Broj povrijeđenih se popeo na 100", " U potresu koji je pogodio Skoplje povrijeđeno je 100 ljudi koji su zatražili pomoć ljekara.\n" +
                "Građani su uglavnom zadobili povrede dok su pokušavali napustiti domove, prenosi Tanjug.\n" +
                "\n" +
                "Agencija MIA je navela da su tri osobe zadržane u bolnici, među kojima i žena koja je pala s terase na prvom spratu.\n" +
                "\n" +
                "Neki od povrijeđenih građana su priznali da se ne bi povrijedili da nisu paničarili.\n" +
                "\n" +
                "Ozlijeđeni su prevezeni u skopske bolnice, uglavnom s prijelomima ruku i nogu i posjekotinama, navode mediji.\n" +
                "\n" +
                "Neki od građana su povrijeđeni prilikom silaska niz stepenice, a neki prilikom iskakanja sa terasa nižih spratova.\n" +
                "\n" +
                "Kako je prenio Reuters, očevici su naveli da je potres izazvao paniku među stanovnicima kao i da su se na pojedinim zgradama pojavile pukotine na zidovima.\n" +
                "\n" +
                "U Skoplju se nedjelju u 15:10 sati osjetio novi jači potres jačine pet stepeni Richterove ljestvice poslije dva slabija potresa koja su u jutarnjim satima uznemirila građane glavnog grada Makedonije.\n" +
                "\n" +
                "Epicentar novog potresa bio je sedam kilometara istočno od Skoplja, javio je Evropski mediteranski seizmološki cenatar.", "Regija", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160911041.jpg?v=1"));
        articles.add(new Article(21, "Razlika između Donalda Trumpa i Baracka Obame na dvije fotografije", " Utrka za predsjednika Sjedinjenih Američkih Država (SAD) još uvijek traje, a svakodnevno se na društvenim mrežama mogu vidjeti prednosti i nedostaci sadašnjeg predsjednika Baracka Obame i republikanskog kandidata Donalda Trumpa koje korisnici objavljuju.\n" +
                "Na Twitteru su se pojavile dvije fotografije koje, prema pisanju tamošnjih medija, oslikavaju razliku između Trumpa i Obame.\n" +
                "\n" +
                "Naime, fotografije prikazuju kako se ova dvojica muškaraca ponašaju na kiši. Dok Trump \"štiti svoju frizuru\" od nevremena velikim crnim kišobranom, Obama s druge strane kisne, a njegov tjelohranitelj nosi kišobran iznad njegove supruge Michelle.\n" +
                "\n" +
                "Ovaj post na Twitteru do sada je ritvitovan više od 2.000 puta, a iako ovo nije velika brojka za Twitter, ipak pokazuje koliko su brzo ljudi spremni analizirati samo dvije fotografije.\n" +
                "\n" +
                "Pretpostavlja se da je fotografija Donalda Trumpa napravljena na Floridi 24. augusta, a pored njega se nalazi tužiteljica Floride Pam Bondi nezaštićena kišobranom.", "Svijet", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160920076.jpg?v=3"));
        articles.add(new Article(22, "Američka kompanija Liberty Media kupuje Formulu 1", "Američka kompanija Liberty Media je potvrdila da kupuje šampionat Formule 1 za 4,4 milijarde dolara. \n" +
                "Ovaj potez kompanije Liberty Media je okončao višegodišnje spekulacije o vlasništvu kompanije. Bernie Ecclestone će ostati šef, ali će potpredsjednik kompanije 21st Century FOx postati novi predsjednik.\n" +
                "\n" +
                "Kompanija Liberty Media ima svoj udio u nekoliko različitih sportova i biznisa iz entertainment svijeta uključujući bejzbol klub Atlanta Braves.\n" +
                "\n" +
                "Liberty Media je u vlasništvu milijardera Johna Malonea, a prvobitno će kupiti manji udio Formule 1. Kada dobije dozvolu regulatornih tijela, uslijedit će potpuno preuzimanje šampionata.\n" +
                "\n" +
                "Ukupna vrijednost transakcije iznosi 8 milijardi dolara, ali uključuje 4,1 milijardu dolara duga koji ima Formula 1. Liberty Media kupuje udio privatne kompanijce CVC Capital, koji je u Formuli 1 deset godina, ali je dio dionica prodao 2012. godine. Kompanija je kritikovana da uzima velik dio profita iz ovog sporta, koji pati zbog smanjenja gledanosti u proteklih nekoliko godina.", "Sport", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160908017.jpg?v=1"));
        articles.add(new Article(23, "Norwegian Air poziva žene da putuju u Los Angeles reklamom \"Brad je slobodan\"", "Informacija o razvodu slavnog para Angeline Jolie i Brada Pitta šokirala je javnost, a mediji danima pišu o detaljima ove priče. I dok se drugi fokusiraju na loše strane, Norwegian Air odlučio je iskoristiti ovaj događaj u marketinške svrhe.\n" +
                "Tako ova aviokompanija poziva putnice da putuju u Los Angelesu po promotivnoj cijeni od 1.199 kruna (130 eura).\n" +
                "\n" +
                "\"Brad je slobodan. Let za Los Angeles u jednom smjeru sa taksama 1.199 kruna\", stoji u reklami koju su objavili u norveškim i britanskim novinama.\n" +
                "Većina zaposlenika u marketinškom sektoru ocijenila je ovaj marketinški potez genijalnim, a da li će upaliti bit će poznato za nekoliko dana kada će kompanija uraditi procjenu.\n" +
                "\n" +
                "Znajući kako se slavne osobe brzo \"riješe\" samoće, odnosno nađu novog partnera, ovo je dobra prilika za sve slobodne žene da osvoje srce popularnog glumca.", "Zanimljivosti", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160923037.jpg?v=1"));
        articles.add(new Article(24, "Čović za Klix.ba: U narednih šest mjeseci riješit ćemo pitanje Sejdić-Finci, upitnik očekujemo za tri mjeseca", "Član Predsjedništva BiH iz reda hrvatskog naroda Dragan Čović u razgovoru za Klix.ba je istakao zadovoljstvo današnjim zvaničnim prihvatanjem aplikacije naše zemlje za članstvo u Evropsku uniju, ali je naglasio potrebu stvaranja nove i brže dinamike u ispunjavanju uslova EU.\n" +
                "\"Ova poruka i ohrabrenje iz Brisela sve će nas mobilizirati. Nemamo razloga da zbog bilo koje lokalne teme sebi zamagljujemo evropski put. Što prije moramo napraviti novu agendu koja će u potpunosti biti podređena evropskom i euroatlanskom putu\", kazao je Čović na početku razgovora za Klix.ba.\n" +
                "\n" +
                "Ipak, jasno je da BiH ne smije usporiti provođenje reformi i ispunjavanje uvjeta ukoliko želi imati kontinuitet ka evropskom putu. Evropska komisija će BiH u narednim mjesecima dostaviti upitnik sa nekoliko hiljada pitanja, na osnovu kojih naša zemlja treba dati precizne odgovore o svim segmentima privrede, ekonomije, industrije, društva i ostalih kategorija kako bi dobili kandidatski status za članstvo u EU.\n" +
                "\n" +
                "\"BiH se mora opredijeliti želi li ka evropskom putu ići brže ili sporije. Svima odgovara jedna brža dinamika, a u naredna dva ili tri mjeseca očekujemo da ćemo dobiti i upitnik Evropske komisije, a do devetog ili desetog mjeseca 2017. godine dobit ćemo i kandidatski status. Do tada moramo kontinuirano raditi i postaviti novu dinamiku za preuzete obaveze. Jednostavno bilo bi glupo ne iskoristiti ohrabrenje i dobru volju čelnika Evropske unije\", naglašava Čović.\n" +
                "\n" +
                "Napomenuo je i da je neophodno ispunjavati i obaveze na unutarnjem planu, a koje su često bile prepreka evropskom putu naše zemlje.\n" +
                "\n" +
                "\"Nakon prihvatanja naše aplikacije za članstvo u EU mi ćemo morati ubrzo riješiti presude iz Strazbura i hrvatsko pitanje, jer bez toga nećemo dobiti kandidatski status. Pitanje Sejdić-Finci riješiti ćemo u narednih tri do šest mjeseci\", ističe Čović.\n" +
                "\n" +
                "Dodaje da je prioritet u narednom periodu da svi segmenti vlasti naporno rade, jer ovo je šansa koju ne smijemo propustiti.\n" +
                "\n" +
                "\"Evropski put nema alternative i do nas je koliko ćemo brzo napredovati na tom putu. Moramo sustići evropski put Srbije i Crne Gore\", zaključio je Čović u razgovoru za Klix.ba.", "BiH", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160920104.jpg?v=1"));
        articles.add(new Article(25, "Grabar-Kitarović: Hrvatska nema vremena za nova politička nadmudrivanja", "Predsjednica Republike Hrvatske Kolinda Grabar-Kitarović u ponedjeljak je nakon objave potpunih rezultata prijevremenim parlamentarnim izborima, čestitala svim izabranim zastupnicima te relativnom pobjedniku izbora, HDZ-u i njegovom čelniku Andreju Plenkoviću, a naglasila je da u konzultacijama za sastavljanje Vlade neće dopustiti odugovlačenja i ultimatume koji iritiraju hrvatsku javnost, \"jer Hrvatska nema vremena za gubljenje\".\n" +
                "\"Unatoč pojedinačnim neprimjerenim izjavama, protekla predizborna kampanja predstavlja značajan demokratski iskorak s obzirom da je najvećim dijelom bila usmjerena na egzistencijalne probleme hrvatskih ljudi, a ne na podjele. No, slabiji odaziv na ovim izborima moramo shvatiti kao poruku upozorenja svima da odgovornije obnašaju povjerene dužnosti i vrate povjerenje u politiku i političare“, izjavila je hrvatska predsjednica nakon što je Državno izborno povjerenstvo (DIP) objavilo potpune neslužbene rezultata glasovanja.\n" +
                "\n" +
                "Konsultacije za sastavljanje Vlade, najavila je Grabar-Kitarović, započet će nakon što od DIP-a dobije konačne službene rezultate izbora, prenosi Hina. \n" +
                "\n" +
                "\"Želim vrlo jasno naglasiti kako neću dopustiti odugovlačenja i ultimatume koji iritiraju hrvatsku javnost i nisu put prema izgradnji međusobnog povjerenja kao temelja stabilne vlade. Hrvatska nema vremena za nova politička nadmudrivanja. Treba nam odlučno i kompetentno vodstvo okrenuto budućnosti, koje će osigurati stabilnost, razvoj i gospodarski rast\", poručila je predsjednica Republike Hrvatske.\n" +
                "\n" +
                "Dodala je kako vjeruje da će vrlo brzo dobiti dokaz o podršci natpolovične većine svih zastupnika u Hrvatskom saboru za novog mandatara, jer, ponovno je naglasila, Hrvatska nema vremena za gubljenje.", "Regija", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160912075.jpg?v=1"));
        articles.add(new Article(26, "Sin Donalda Trumpa izbjeglice uporedio s otrovnim bombonama", "Sin Donalda Trumpa Donald Trump Junior našao se ove sedmice na udaru američke javnosti nakon što je izbjeglice uporedio s otrovnim bombonama, piše Guardian.\n Na svom Twitter profilu Trump Junior je napisao: \"Da imam zdjelu Skittlesa i kažem ti da će te samo tri ubiti, da li bi uzeo pregršt? To je naš problem sa sirijskim izbjeglicama\". Ove riječi propraćene su sloganom kampanje njegovog oca \"Make America Great Again\" i protumačene kao sugestija da Sjedinjene Američke Države (SAD) ne trebaju nikako primati izbjeglice.", "Svijet", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160920081.jpg?v=1"));
        articles.add(new Article(27, "Studenti pred utakmicu protiv Konjuha: Protivnik je favorit, ali se nadamo punom plijenu\n", "Prva konferencija za medije Rukometnog Kluba Bosna Sarajevo u novoj premijerligaškoj sezoni je održana danas u dvorani Ramiz Salčin povodom nadolazeće subotnje utakmice u kojoj će Studenti dočekati ekipu Konjuha. \n" +
                "U ime sarajevskog kluba novinarima su se obratili šef stručnog štaba Adem Bašić, kapiten ekipe Adis Hrbat i prvotimac Goran Šarenac.\n" +
                "\n" +
                "Bašić je istakao da je ekipa Konjuha blagi favorit, no da i Bosna ima svoje adute.\n" +
                "\n" +
                "\"Očekujemo tešku utakmicu, Konjuh je ekipa koja nas je dobila nedavno na turniru u Zenici, ali to je bila pripremna utakmica i ne mora biti značajan pokazatelj trenutnog stanja. Oni su blagi favoriti, ali i mi imamo svoje adute i opravdane razloge da se nadamo punom plijenu. U Prijedoru smo poraženi spletom raznih okolnosti, no, tu utakmicu smo već zaboravili te je sva naša pažnja usmjerena ka sutrašnjem susretu. Nadam se pozitivnom rezultatu. Pritisak postoji, no mi smo uvijek pod pritiskom bodova, bez obzira na protivnika, tako da, iz tog ugla ova utakmica nije ništa drugačija od ostalih. Naš cilj mora biti Liga 4 i učinit ćemo sve da to i ostvarimo\", izjavio je Bašić.\n" +
                "\n" +
                "Kapiten RK Bosna Sarajevo, Adis Hrbat, obećao je veliku borbu i zalaganje ekipe.\n" +
                "\n" +
                "\"U Prijedoru smo držali egal do 55. minute, no, nismo uspjeli doći do pozitivnog rezultata, ali pred nama je nova utakmica. Atmosfera na treninzima je sjajna, radili smo naporno ove sedmice, zdravstveni bilten je dobar i spremni smo za sutrašnji derbi. Ono što možemo obećati je da ćemo učiniti sve da bodovi ostanu u Sarajevu, kako i treba da bude\", rekao je Hrbat.\n" +
                "\n" +
                "Šarenac je pozvao navijače da dođu u što većem broju na Mojmilo.\n" +
                "\n" +
                "\"Konjuh je izuzetno kvalitetan protivnik kojeg dobro poznajemo. Sigurno da svim ekipama poslije Konjuha koje budu dolazile ovdje, Mojmilo će biti vruć teren i jako teško će dolaziti do bodova. Želimo da se iskupimo za Prijedor, da nuliramo taj poraz. Mislim da imamo čemu da se nadamo sutra i ovom prilikom pozivam navijače da nas bodre, kako u sutrašnjoj utakmici, tako i u svakoj narednoj. Obećavamo borbu od prve do posljednje minute\", kazao je Šarenac.\n" +
                "\n" +
                "\n" +
                "Utakmica između Bosne i Konjuha se igra u subotu, 17. septembra, u dvorani \"Ramiz Salčin\" na Mojmilu, sa početkom u 20 sati, a cijena ulaznice je 5 KM.", "Sport", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160916086.jpg?v=1"));
        articles.add(new Article(28, "Veterinari u Velikoj Britaniji traže od građana da ne kupuju buldoge i mopse", "Veterinari u Velikoj Britaniji upozorili su građane da ne kupuju pse sa \"spljoštenim\" licima. Ovakvi psi imaju brojne zdravstvene probleme, što nije dobro ni za psa ni vlasnika.\n" +
                "Prema navodima Independenta, psi širokih i spljoštenih lica su se počeli uzgajati jer se ljudima takav izgled dopadao. Međutim, njihove kratke njuške im stvaraju probleme jer imaju kratka grla i disajne puteve. \n" +
                "\n" +
                "Buldozi, mopsi, francuski buldozi i shih-tzui postaju sve popularniji u Velikoj Britaniji, što je zabrinulo veterinare. Oni tvrde da ovi psi pate od niza zdravstvenih poteškoća, poput čira na oku, bolnih nepravilnosti s kičmom i teških disajnih poteškoća.\n" +
                "\n" +
                "Predsjednik Britanske veterinarske asocijacije (BVA) Sean Wensley rekao je da bi ljudi trebali razmisliti da uzmu druge vrste pasa. \n" +
                "\n" +
                "\"Porast u popularnosti ovih pasa povećao je patnju životinja i rezultirao nezdravim životinjama za vlasnike, tako da mi preporučujemo ljudima da razmisle i izaberu zdraviju vrstu ili mješanca\", rekao je on, prenosi Independent.", "Zanimljivosti", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160922009.jpg?v=1"));
        articles.add(new Article(29, "\"Let’s Do It - Landslide Risk Reduction\": Volonteri isplanirali nove akcije", "\n" +
                "Proteklog vikenda na Ekonomskom fakultetu Univerziteta u Sarajevu održana je konferencija pod nazivom \"Let's Do It - Landslide Risk Reduction\" na kojoj su učestvovali koordinatori \"Let's Do It\" volonterskih akcija širom Bosne i Hercegovine. Cilj događaja bio je predstavljanje značaja šuma i drveća u prevenciji nastanka novih kliziša i sanaciji postojećih. Jedan od značajnih koraka na tom putu su i akcije pošumljavanja, koje ova organizacija provodi na području Bosne i Hercegovine od 2013. godine. Učesnici konferencije su imali priliku slušati predavanja stručnjaka o stanju šuma u našoj zemlji, s posebnim fokusom na problematiku ljudskog nemara prema šumskim područjima, u vidu ilegalne sječe šume, kao i namjerno i slučajno izazvanim požarima.\n" +
                "\n" +
                "Šume i šumska zemljišta u Bosni i Hercegovini rasprostiru se na površini od oko 56,7% površine države, prema podacima iz Druge inventure šuma na velikim površinama (2006-2009). Prema mišljenju određenog broja stručnjaka, riječ je o zemlji koja je izuzetno bogata šumama, o kojima se, nažalost, iz dana u dan sve manje vodi računa. Učesnici su ovaj susret iskoristili kako bi kreirali okvirni plan za realizaciju volonterskih akcija čišćenja ilegalnih deponija otpada i sadnje drveća, koje nas očekuju u skorijoj budućnosti, saopćeno je.\n" +
                "\n" +
                "Kroz evaluaciju dosadašnjih Let's Do It akcija sadnje konstatovano je gdje ima mjesta za poboljšanje kako bi naredne akcije bile što uspješnije, a usvojeni su i koraci za snažnije međusobno povezivanje lokalnih općinskih timova, kao i svojevrsna strategija budućeg djelovanja na osnovu kojih Let's Do It želi da bude pokretačka snaga budućih društveno pozitivnih promjena.\n" +
                "\n" +
                "Događaj su podržali Ambasada Švicarske u Bosni i Hercegovini, BH Telecom, Eko život, kao i Ured specijalnog predstavnika Evropske unije u BiH i UN Volonteri.\n" +
                "\n" +
                "Naredna akcija sadnje drveća bit će realizovana na teritoriji cijele Bosne i Hercegovine 22. i 23. oktobra 2016. sa početkom u 9 sati. Više informacija dostupno je na web stranici www.letsdoit.ba, ali i Facebook Fan pageu Let’s Do It – očistimo zemlju za 1 dan.", "BiH", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/160920087.2_xl.jpg"));
        articles.add(new Article(30, "Mesić: Milorad Dodik je novi Slobodan Milošević", "Predsjednik Republike Srpske Milorad Dodik je novi Slobodan Milošević, a poruke političara na relaciji Zagreb - Beograd su veoma opasne, iako su plod predizborne kampanje, izjavio je nekadašnji predsjednik Hrvatske Stjepan Mesić.\n" +
                "Mesić je za Alo rekao da je o Miloradu Dodiku sve što je imao da kaže \u0093već davno rekao i da isto misli i danas\u0094.\n" +
                "\n" +
                "Podsjećamo, Mesić je ranije izjavio da je Dodik novi Slobodan Milošević na Balkanu i da međunarodna zajednica ne smije više da prihvata da lider RS-a postojanje Bosne i Hercegovine stalno stavlja pod znak pitanja prijetnjama referendumom o otcjepljenju.\n" +
                "\n" +
                "Upitan da li su trenutne trzavice na relaciji Zagreb - Beograd plod predizborne kampanje ili je u pitanju nešto drugo, Mesić je konstatovao da su plod kampanje, ali i da su izjave političara veoma opasne.\n" +
                "\n" +
                "\u0093Primarno su plod predizborne kampanje, a dijelom i nespremnosti vodećih političara da shvate opasnost trajnog pogoršanja međusobnih odnosa\u0094, rekao je Mesić, a prenosi Blic. \n" +
                "\n" +
                "On je dodao i da ne vjeruje da će Hrvatska blokirati Srbiju na putu ka članstvu u EU, jer to, kako je ocenio, ne bi bilo ni u interesu Hrvatske.", "Regija", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160908058.jpg?v=1"));
        articles.add(new Article(31, "Sjeverna Koreja uspješno testirala novi raketni motor", "Sjeverna Koreja je obavila uspješan test novog raketnog motora pomoću kojeg namjerava lansirati satelite, javljaju državni mediji. \n" +
                "Sjevernokorejski vođa Kim Jong-un je naredio naučnicima i inžinjerima da se pripreme za lansiranje satelita što prije, javlja agencija KCNA. Radi se o samo jednom u nizu testova povezanih s lansiranjem projektila.\n" +
                "\n" +
                "U međuvremenu su SAD i Kina dogovorile saradnju te će se zajednički pozabaviti petim nuklearnim testom koji je izvršila sjeverna koreja. Podzemni nuklearni test obavljen ranije ovog mjeseca bio je i najuspješniji svih vremena u ovoj zemlji. Sjeverna Koreja redovno objavljuje informacije o napretku nuklearnog i raketnog programa, no, analitičari kažu da je te navode nemoguće potvrditi.\n" +
                "\n" +
                "Američki i kineski zvaničnici su započeli razgovore o mogućim sankcijama koje bi UN trebao nametnuti Sjevernoj Koreji kao odgovor na nuklearne testove. Peking se još uvijek nije izjasnio da li će podržati strožije mjere protiv Pyongyanga.\n" +
                "\n" +
                "Kina je glavni partner i saveznik Sjevernoj Koreji, ali je i ova zemlja sve manje tolerantna zbog vojnih poteza i agresivne retorike Kima Jong-una. Podrška Kine je ključna kako bi sankcije dale rezultate, no Kinezi smatraju da takvi koraci nisu adekvatan odgovor na situaciju.\n" +
                "\n" +
                "Kim Jong-un je lično nadgledao testiranje raketnog motora na području Sohae namijenjenom lansiranju satelita. Tu je Sjeverna Koreja lansirala raketu u februaru, koja je navodno nosila satelit.\n" +
                "\n" +
                "Raketni motor će omogućiti Sjevernoj Koreji lansiranje različitih satelita među kojima su i oni za \"posmatranje Zemlje na svjetskom nivou\".\n" +
                "\n" +
                "Pyongyang će navodno uskoro lansirati novu dalekometnu raketu, a konstantno tvrdi da svoj svemirski program razvija isključivo u naučne svrhe, dok SAD, Južna Koreja, pa čak i Kina tvrde da je pravi cilj razvoj interkontinentalnih balističkih projektila.\n" +
                "\n" +
                "Vijeće sigurnosti UN-a ne dozvoljava Sjevernoj Koreji da provodi bilo kakve testove nuklearnih i balističkih projektila.", "Svijet", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160909001.jpg?v=1"));
        articles.add(new Article(32, "Guardiola: Toure neće igrati dok se njegov agent ne izvini", "Menadžer Manchester Cityja Pep Guardiola poručio je da neće vratiti Yayu Tourea u tim dok se njegov agent ne izvini za kritikovanje trenerove odluke o izostavljanju ovog igrača. \n" +
                "Cijeli slučaj izazvalo je nepojavljivanje 33-godišnjeg igrača u ekipi u utakmici Lige prvaka. Toureov agent Dimitri Seluk izjavio je da je ovim potezom fudbaler ponižen, a Guardiola je na to poručio: \"Seluk se mora izviniti. Ako to ne uradi, Toure neće igrati\".\n" +
                "\n" +
                "Ipak, agent je za BBC Sport pitao: \"Za šta se to trebam izviniti? On bi trebao porazgovarati sa Yayom. Yaya radi svoj posao. Vidjet ćemo šta će se desiti. Njegov ugovor ističe na kraju sezone i u januaru će biti slobodan igrač\".\n" +
                "\n" +
                "Guardiola je o igraču svoje ekipe rekao: \"Bilo mi je teško ubaciti ga u tim u utakmici Lige prvaka. Poznajem ga, znam da je dobar momak, ali dan poslije njegov menadžer je progovorio. U tom trenutku Yaya je ispao iz kombinacija. Kao trener ne mogu prihvatiti da kada igrač ne igra odlazi medijima i govori\".\n" +
                "\n" +
                "Dodao je da Seluk nije imao hrabrosti da ga nazove, ali da se uvijek može izviniti putem medija.\n" +
                "\n" +
                "\"Kad se to dogodi Yaya će biti dio tima i imat će iste šanse da igra u svim utakmicama\", poručio je menadžer Cityja.", "Sport", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160921018.jpg?v=1"));
        articles.add(new Article(33, "Kineski milijarder psu kupio osam iPhonea", "Wang Sicong, sin kineskog milijardera Wanga Jianlina, kupio je svom psu osam uređaja iPhone 7 na dan puštanja u prodaju, piše CNN.\n" +
                "Prošle sedmice fanovi kompanije Apple su se svrstali u redove širom Kine kako bi dobili šansu da kupe jedan od tek puštenih u promet uređaja iPhone 7 i iPhone 7 Plus. Jedan iPhone korisnik nije morao brinuti da neće dobiti svoj uređaj: aljaski malamut Coco. \n" +
                "\n" +
                "Cocov vlasnik Wang Sicong na dan puštanja u promet svom je ljubimcu osigurao osam ovih uređaja, prema informacijama na kineskoj verziji Twittera Weibou, gdje ovaj pas ima svoj nalog. \n" +
                "\n" +
                "U Kini ovi telefoni koštaju od 1.047 do 1.197 američkih dolara.\n" +
                "\n" +
                "Ovo nije prvi put da Wang psu kupuje skupocjene Appleove proizvode. Prošle godine bio je meta kineske javnosti jer je postavio fotografije Cocoa sa dva luksuzna Apple sata vrijedna više od 37.000 američkih dolara. Ovaj bogataš je dosta kritikovan u Kini zbog besramnog iskazivanja bogatstva, a brendiran je kao \"bogataš druge generacije\", odnosno sin bogatih roditelja.", "Zanimljivosti", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/160920040.2_mn.jpg"));
        articles.add(new Article(34, "Kina: Uhvaćeni krijumčari s iPhoneima pričvršćenim za tijelo", "U južnoj kineskoj pokrajini Guandong uhvaćeni su krijumčari više od 400 telefona iPhone 7 i iPhone 7 Plus, rekli su iz carinskog ureda u nedjelju, javlja kineska novinska agencija Xinhua.\n Najnoviji produkt američke kompanije Apple tek je nedavno pušten u promet, a već je pridobio pažnju krijumčara i počeo stvarati neprilike carinicima. Jedan od prvih slučajeva dolazi iz Kine, gdje su službenici koji rade na carini rekli da su od četvrtka po kineskom vremenu, kada je telefon pušten u promet, pa do subote, imali više od 60 slučajeva krijumčarenja iPhone 7 pametnih telefona. Većina krijumčara telefone je skrivala negdje na tijelu.\n" +
                "\n" +
                "Granična policija rekla je da su optuženi bili većinom plaćeni krijumčari koji dobijaju 200-300 yuana (30-45 američkih dolara) po akciji. Jedna osoba je pronađena sa 30 iPhonea pričvršćenih za tijelo.\n" +
                "\n" +
                "Iz carine je rečeno da će počinioci platiti kaznu od 15 posto ili se suočiti s prijavama za krijumčarenje.", "Svijet", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160915067.jpg?v=1"));

        articles.add(new Article(35, "EU danas prihvata aplikaciju BiH za članstvo, upitnik možemo očekivati uskoro", " \n" +
                "Vijeće za opće poslove Evropske unije (EU) danas će razmatrati aplikaciju BiH za članstvo u EU, a bh. politički lideri su optimistični da će aplikacija biti prihvaćena.\n" +
                "Nakon usvajanja predviđenih mjera iz Reformske agende, konačnog usaglašavanja mehanizma koordinacije te potpisivanja Sporazuma o stabilizaciji i pridruživanju (SSP), što su bili ključni preduvjeti, BiH danas očekuje prihvatanje aplikacije za članstvo u EU.\n" +
                "\n" +
                "Ukoliko Vijeće za opće poslove Evropske unije da zeleno svjetlo za BiH, odmah će biti zadužena Evropska komisija da u narednih nekoliko mjeseci pripremi upitnik za BiH, na koji će u toku 2017. godine naša zemlja odgovarati i na koncu vjerovatno i dobiti kandidatski status za EU.\n" +
                "\n" +
                "Uoči današnje sjednice naročito je optimističan bio predsjedavajući Vijeća ministara BiH Denis Zvizdić koji je ranije za Klix.ba kazao kako će prihvatanje aplikacije BiH značiti novi nivo odnosa naše zemlje i EU.\n" +
                "\n" +
                "\"Upitnik je ozbiljna stvar i mi ćemo dobiti hiljade različitih pitanja. Na nivou Vijeća ministara BiH smo počeli ozbiljne pripreme za realizaciju, adekvatno i pravovremeno odgovaranje na brojna pitanja. To će ujedno biti inventura onoga što imamo u BiH po brojnim sektorima. Konačno, poslije upitnika nećemo lutati u iznošenju bilo kakvih podataka\", rekao je Zvizdić.\n" +
                "\n" +
                "Uprkos brojnim unutrašnjim problemima, poput najavljenog refrenduma u RS-u, što definitivno predstavlja loš imidž za BiH, Evropska unija će današnjim prihvatanjem aplikacije ohrabriti našu zemlju za nastavak provođenja bitnih reformi.\n" +
                "\n" +
                "Ipak, ni samo prihvatanje aplikacije za članstvo u EU, koju je naša zemlja predala 15. februara ove godine, u praksi ne znače mnogo, osim satisfakcije i ohrabrenja da BiH treba nastaviti putem evropskih integracija, o čemu postoji konsenzus svih strana u BiH.\n" +
                "\n" +
                "Brojni zvaničnici EU u prethodnom periodu istakli su zadovoljstvo postignutim napretkom BiH u implementaciji preuzetih obaveza. Međutim, pred BiH je još mnogo posla, a nastavak evropskog puta zavisi i od unutardržavnih odnosa koji će se uspostaviti nakon lokalnih izbora i referenduma u RS-u.", "BiH", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/b_160919147.jpg?v=1"));
        articles.add(new Article(36, "Kamila pobjegla iz cirkusa i prošetala se Splitom", "Kamila iz cirkusa Safari koji gostuje u Splitu sinoć je oko 1 sat odlučila pobjeći i prošetati se ulicama hrvatskog grada. \n Građani su kamilu primijetili 45 minuta iza ponoći na križanju Jobove i Tesline ulice te su o neobičnom susretu obavijestili policiju. Oni su izašli na teren i stupili u kontakt s radnicima cirkusa koji su odbjeglu kamilu uhvatili i vratili na Poljud, piše dalmacijanews.hr.\n" +
                "\n" +
                "Kako navode, ovo nije prvi put da se kamile otmu kontroli i pobjegnu iz ovog cirkusa. Dogodilo se to krajem jula kada je cirkus gostovao u Zadru. Tri kamile iskoristile su priliku i dale se u bijeg dok su ih pokušavali ukrcati u kamion.", "Regija", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/160903078.1_xl.jpg"));
        articles.add(new Article(37, "Bh. odbojkaši osvojili treće srebro na Paraolimpijskim igrama u Riju", "Bosna i Hercegovina je osvojila svoje treće paraolimpijsko srebro u sjedećoj odbojci u petom uzastopnom finalu protiv Irana. U Rio de Janeiru izabranici Mirze Hrustemovića su poraženi sa 3:1 u setovima (25:21, 21:25, 25:18, 25:15) nakon sat i 34 minute igre. \n" +
                "BiH je tako osvojila treće srebro nakon Sydneyja 2000. i Pekinga 2008. godine, dok je zlato osvojila u Atini 2004. i Londonu 2012. godine.\n" +
                "\n" +
                "Naši odbojkaši su loše ušli u meč. Iranci su poveli sa 6:0 i u nekoliko navrata izabranici Mirze Hrustemovića su uspijevali stizati na dva poena zaostatka, no nakon 24 minute igre Iran je riješio prvi set u svoju korist rezultatom 25:21.\n" +
                "\n" +
                "U drugom setu naši reprezentativci su odigrali mnogo bolje, došli su u jednom trenutku i do plus pet (9:4), što su održavali do kraja seta i osvojili ga rezultatom 25:21 nakon 26 minuta igre.\n" +
                "\n" +
                "U trećem setu vodila se velika borba, rezultat je bio izjednačen sve do sredine, kada Iran odlazi na četiri poena prednosti (16:12). Iskusni Iranci su mirno priveli set kraju i uzeli ga nakon 21 minute sa 25:18.\n" +
                "\n" +
                "\n" +
                "I u četvrtom setu Iranci su se rano odlijepili na plus četiri (6:2), a potom i na plus pet (8:3) nakon najljepšeg i najdužeg poena u finalu. Kada su Iranci došli do 9:3 svi su pomislili da će Iranci bez problema preoteti titulu paraolimpijskog prvaka od naše selekcije, ali su izabranici Mirze Hrustemovića stigli na samo minus dva (10:8). Ipak, Iran se ubrzo vratio u pravi ritam i došao do plus sedam (16:9), što je bio kraj svih nadanja našoj selekciji da će meč odvesti u peti set. Nakon 23 minute igre rezultat četvrtog seta je glasio 25:15.\n" +
                "\n" +
                "\n" +
                "U redovima BiH najbolji je bio Safet Alibašić sa 16 poena, dok je Morteza Mehrzadselakjani, koji je sa 246 cm drugi najviši čovjek na svijetu, predvodio Iran sa 28 poena.\n" +
                "\n" +
                "Srebro za Bosnu i Hercegovinu osvojili su kapiten Sabahudin Delalić, Adnan Kešmer, Mirzet Duran, Armin Šehić, Benis Kadrić, Ismet Godinjak, Adnan Manko, Asim Medić, Nizam Čančar, Dževad Hamzić, Safet Alibašić i Ermin Jusufović. Selektor reprezentacije je Mirza Hrustemović, a treneri su Ejub Mehmedović i Zikret Mahmutović.\n" +
                "\n" +
                "U susretu za treće mjesto Egipat je savladao Brazil sa 3:2 ", "Sport", "23/07/2013", "22:23", "https://static.klix.ba/media/images/vijesti/160918069.5_xl.jpg"));

        String category;
        for (int i = 0; i < articles.size(); i++){
            category = articles.get(i).getCategory();
            switch (category){
                case "BiH":
                    articlesBih.add(articles.get(i));
                    break;
                case "Regija":
                    articlesRegija.add(articles.get(i));
                    break;
                case "Svijet":
                    articlesSvijet.add(articles.get(i));
                    break;
                case "Sport":
                    articlesSport.add(articles.get(i));
                    break;
                case "Scitech":
                    articlesScitech.add(articles.get(i));
                    break;
                case "Zanimljivosti":
                    articlesZanimljivosti.add(articles.get(i));
                    break;

            }
        }

    }

    public static ArrayList<Article> getLastNews(){
        ArrayList<Article> lastThreeArticles = new ArrayList<>();

        for (int i = articles.size()-1; i > 0; i--){
            lastThreeArticles.add(articles.get(i));
            if(lastThreeArticles.size() == 3) {
                break;
            }
        }
        return lastThreeArticles;
    }



}
