
# Ballerz

### Hogy mi is ez?

Előfordult már Veled valaha, hogy egy hosszú nap végén már csak arra vágytál, hogy végre lemehess a grundra és rúghasd a bőrt, de nem volt kivel? A Ballerz applikáció egy kényelmes és egyszerű megoldást biztosít arra, hogy ez többet ne fordulhasson elő Veled! Csak regisztrálj, és válogass a kitűzött mérkőzések között és csatlakozz másokhoz, vagy hozz létre saját eseményt!

### Az alkalmazás funkcionális követelményei

 - A felhasználók regisztrálhatnak, a későbbiekben pedig ezekkel a hitelesítő adatokkal jelentkezhetnek majd be az alkalmazásba.
 - A regisztrált felhasználók létrehozhatnak eseményeket, vagy csatlakozhatnak mások által létrehozottakhoz.
 - A regisztrált felhasználók barátnak jelölhetnek másik regisztrált felhasználókat.
 - A felületen egy hírfolyam-szerű sávban jelennek meg a felhasználó közelében lévő események, helyszín, telítettség, időpont szerint.
 - A felhasználók kedvencnek jelölhetnek helyszíneket, rendszeres eseményeket, szervezőket, amelyek a hírfolyamban is priorítást élveznek majd.
 - A szervezőknek, helyszíneknek saját oldaluk is lesz, a specifikus információkkal.
 - Helyszíneket és szervező felhasználókat csak rendszeradminisztrátorok hozhatnak létre.
 - A baráti kapcsolatban álló regisztrált felhasználók létrehozhatnak csoportokat (csapatokat), amelyek így együttesen szervezhetnek eseményeket és jelentkezhetnek rájuk.
 - A felhasználóknak lehetősége van arra, hogy az események alá hozzászólásokat írjanak.
 - A csapatok egy esemény szervezésekor, vagy egy eseményre jelentkezéskor kiválaszthatják, hogy a csapat mely tagjait szeretnék alapvetően a résztvevők között felsorolni.
 - Azoknak a regisztrált felhasználóknak, akik létrehoztak eseményt, lehetőségük van az esemény történéseit, például gólszerzőket hozzáadni az esemény leírásához.
 - Egy esemény szervezőjének lehetősége van olyan beállítást megadni az eseményhez, amely biztosítja számára a lehetőséget arra, hogy ő fogadhassa el az eseményére leadott jelentkezéseket.
 - A regisztrált felhasználók az adatlapjukon a lejátszott mérkőzések alapján statisztikákat tehetnek közzé.
 - A statisztikák alapján a rendszer a játékosokat rangsorolja.

### Az alkalmazás nem funkcionális követelményei

 - Az alkalmazásnak átláthatónak és könnyen kezelhetőnek kell lennie.
 - Az alkalmazásnak az adatokat biztonságosan kell kezelnie és tárolnia, kiváltképpen az érzékeny hitelesítő adatokat, amelyek az autentikációhoz szükségesek.
 - Az alkalmazásnak gyors válaszidejűnek kell lennie.
 - Az alkalmazásnak szinte folyamatosan, minimális rendszerleállásokkal kell működnie a problémák elkerülése miatt.
 - A rendszer adatbázisának jól szervezettnek kell lennie, a dinamikusságot elősegítve.

### Szakterületi fogalomjegyzék

 - mérkőzés: egy olyan esemény, ahol játékosok által alkotott csapatok csapnak össze és az nyeri meg, amelyik több gólt szerez
 - gól: az az esemény, amikor a labda áthalad a gólvonalon
 - gólpassz: a gólszerző játékosnak a gól szerzése előtt adott utolsó passz
 - kapott gól nélküli mérkőzés: olyan mérkőzés, ahol a csapat kapott gól nélkül fejezi be a meccset
 - bajnokság: több mérkőzésből álló versenysorozat, melyet a döntő mérkőzés győztes csapata nyer meg

### Szerepkörök

 - (regisztrált) felhasználó: általános felhasználó, akinek lehetősége van arra, hogy eseményeket szervezzen és eseményeken vegyen részt
 - szervező: olyan regisztrált felhasználó, akinek csak eseményszervezésre van lehetősége
 - moderátor: olyan felhasználó, akinek joga van az eseményekhez fűzött kommenteket, valamint az azokat író felhasználókat moderálni
 - rendszeradminisztrátor: olyan felhasználó, akinek joga van szervezőket, helyszíneket létrehoznia, moderátori jogokkal bír, valamint természetesen az egyszerű felhasználó jogai is megilletik

### Fejlesztői környezet, használt technológiák

#### A backend-hez használt technológiák

A fejlesztés során a **Spring** keretrendszer (legfrissebb stabil *2.2.0*-ás verziójának) segítségével készítünk el egy **Java** (*8*) alapú alkalmazást, melynek menedzselésének és build folyamatának automatizálása során a **Maven**t hívjuk segítségül. A fejlesztés során az **Apache NetBeans** (*11*) integrált fejlesztői környezetet használjuk.
A Spring Boot **függőségek** közül az alábbiakat vesszük igénybe:
 - Spring Data JPA *(Spring Data-át és Hibernate-et használva a Java Persistence API segítségével SQL-ben tárolja az adatokat)*,
 - Spring Boot DevTools *(gyors alkalmazás újraindításokat, valós idejű újratöltést és különböző konfigurációs lehetőségeket biztosít)*,
 - H2 Database *(gyors memóriában tárolt adatbázist biztosít, ami támogatja a JDBC API-t)*,
 - Lombok *(annotációkat tartalmazó könyvtár a kód elburjánzás megelőzésének érdekében)*,
 - Spring Web *(támogatja a webes alkalmazások készítését, kiváltképp a REST alapokon mozgókét SPRING MVC felhasználásával)*,
 - Spring Security *(testreszabható autentikációs és elérés-kezelő keretrendszer)*.

#### A frontend-hez használat technológiák

A fejlesztés során az **Angular** keretrendszert használjuk, melyhez szükség van a **Node.js** (legfrissebb stabil *12.13.1*-es verziójú) szoftverrendszerre és az ehhez tartozó **NPM** (*6.12.1*-es verziójú) csomagkezelőre.
A telepítés sikerességét az alábbi parancsok (parancssorban való) futtatásával ellenőrizhetjük (azaz megtudhatjuk a verziószámokat):

```
node -v
npm -v
```
A keretrendszer használatához szükségünk lesz még a **TypeScript** telepítésére, amely lehetővé teszi, hogy a **JavaScript** nyelv segítségével skálázható alkalmazást készítsünk, valamint telepítenünk kell az **Angular CLI** szoftvert is (*Angular Command Line Interface*), amely lehetővé teszi a parancssorból való segédműveleteket, amelyek által jóval gyorsabb és kényelmesebb lesz a fejlesztés. A felhasználói felület elkészítéséhez a **Material UI** eszközeit használjuk az egyes komponensek elkészítéséhez, a rácsos elrendezéshez pedig a **flex-layout**-ot..
A telepítéshez (ha a fentebb említett eszközöket már telepítettük) az alábbi utasításokat kell (parancssorban) lefuttatni:

```
npm install -g typescript
npm install -g @angular/cli
npx ng add @angular/material
npm install @angular/flex-layout --save
```

A kódoláshoz a nyílt forráskódú *Microsoft* által fejlesztett **Visual Studio Code** (*1.40*) szoftvert használjuk, amely a hibakereső és Git támogatással hozzájárul a hatékony és zökkenőmentes fejlesztéshez. 

### Adatbázis-terv (UML)

![UML](src/main/resources/ballerz.png)

### Alkalmazott könyvtárstruktúra

Az alkalmazás elkészítése során törekedtünk a lehető legegyszerűbb, legészszerűbb és legátláthatóbb könyvtárstruktúra kialakítására, ezért szorosan ragaszkodtunk az objektumorientált szemléletmód és az ehhez ezer szállal kötődő Java nyelv által elterjedt felépítéshez.

#### Programkönyvtár gyökere

TODO: a leírás kiegészítése az új fájlokkal

* **.git mappa** *(verziókezelő számára szükséges fájlokat és almappákat tartalmaz)*
* **.mvn mappa** *(a Maven build rendszer számára szükséges fájlokat és almappákat tartalmaz)*
* **src mappa** *(a program forráskódját, valamint néhány a fordításhoz és az egyes Spring Boot komponensek kielégítő működéséhez információt tároló konfigurációs fájlt tartalmazó mappa)*
   * **main mappa** *(a forráskód lényegi része, az objektumok implementációja)*
      * **java mappa** *(a mappa tartalmazza a forráskód package-ek szerint tagolt mappaszerkezetét)*
         * **hu mappa** *(a hu package-et jelképező mappa)*
            * **elte mappa** *(az elte package-et jelképező mappa)*
               * **ballerz mappa** *(a ballerz package-t jelképező mappa)*
                  * **controllers mappa** *(a mappa tartalmazza azokat a forrásfájlokat, amelyek az egyes entitásokat kezelik a REST alapú alkalmazás elvei szerint, különböző mapping-eket hajthatunk végre velük)*
                  * **entities mappa** *(a mappa tartalmazza azokat a forrásfájlokat, amelyek megvalósítják az egyes entitásokat)*
                  * **repositories mappa** *(a mappa tartalmazza azokat a forrásfájlokat, amelyek az egyes entitások számára lehetővé teszik a CRUD hívásokat)*
                  * **security mappa** *(a mappa tartamazza az autentikációhoz szükséges forrásfájlokat)*
                  * **utils mappa** *(a mappa különböző mellékes forrásfájlokat tartalmaz, főleg különböző felsorolókat)*
                  * **BallerzApplication.java** *(az alkalmazás belépési pontját tartalmazó forrásfájl)*
      * **resources mappa** *(a mappa tartalmazza a programhoz szükséges "nyersanyagokat", azokat a fájlokat, amelyek nem nevezhetőek kifejezetten forráskódnak, mégis elengedhetetlenek a kielégítő működéshez)*
         * **application.properties** *(tartalmazza az alkalmazás egyes függőségeinek értékadás-szerű utasításokkal való konfigurációját)*
         * **data.sql** *(a H2 Database számára szükséges SQL forrásfájl, amely tartalmazza azokat az utasításokat, amelyeket az adatbázisban a program futása előtt el kell végezni)*
         * **ballerz.png** *(az előző fejezet által tartalmazott kép)*
   * **test mappa** *(az implementációkhoz készített tesztesetek, ahol ezt a jellegük indokolja, avval azonos struktúrában)*
* **target mappa** *(a forrásfájlok alapján legenerált class és egyéb konfigurációs fájlokat, valamint az alkalmazás futtatható verzióját tartalmazza)*
* **.gitignore** *(a fájl tartalmazza azokat a fájlokat (vagy mintákat), amelyeket a verziókezelő rendszernek figyelmen kívül kell hagynia)*
* **HELP.md** *(tartalmaz néhány hasznos linket, amelyek segíthetnek a Spring Boot egyes komponenseinek megértésében, ezt a fájlt a Spring Initalizr generálja)*
* **mvnw és mwnw.cmd** *(a Maven-Wrapper-hez szükségesek, letöltik a megfelelő Maven verziót (ha nem találja), lehetővé teszik a Maven futtatását akkor is, ha azt nem találják a számítógépen - a mvnw a Linux rendszereken, a mvnw.cmd pedig a Windows rendszerek használható)*
* **nbactions.xml** *(a NetBeans fejlesztőkörnyezet által használt konfigurációs fájl, amely leírja, hogy melyik Maven "célokat (goals)" kell alkalmaznia)*
* **pom.xml** *(a Maven által használt konfigurációs fájl, amely információkat tartalmaz a projektről és annak felépítéséről, kezdve annak nevétől, a package-ek strúktúráján át az egyes függőségek leírásáig minden fontos adattal a build folyamatról és az egyes pluginokról)*
* **README.md** *(a verziókövető rendszer (pl. Git) által alkalmazott szöveges fájl, mely arra szolgál, hogy a projekt iránt érdeklődők tájékozódhassanak azokról a fontos információkról, amelyeket a fejlesztők megosztanának velük (például a könyvtárstruktúra részletes leírását, remélem mindenki elolvassa idáig haha))*

### Végpont-tervek és leírások

#### Az alkalmazás egyszerű végpontjai

Az alábbi végpontok az egyes entitásokat jelképezik.

* ```../events```
* ```../matches```
* ```../players```
* ```../statistics```
* ```../users```

#### H2 Database végpontja

Az alábbi végponton érhető el a H2 Database adatbáziskezelő felülete, természetes kizárólag autentikáció után (ez az adatbázis saját autentikációját használja).

* ```../h2-console```

#### Hiba végpont

Amennyiben az alkalmazás futása során hiba következik be, esetleg a felhasználó kérése nem megvalósítható, az alábbi végpontra kerül a felhasználó.

* ```../error```

#### A végpontok működésének leírása

A leírást szekvenciadiagram formájában mutatjuk be, ez a viselkedés jellemző minden eddigi végpontra.

![SEQUENCE](src/main/resources/sequence.png)

### Specifikumok

Egyelőre az alkalmazás nem tartalmaz említésre méltó specifikumot.

### Szerepkörök hozzáférési jogai

Az alábbi használati eset diagramok szemléltetik azt, hogy az egyes szerepkörök mely elemekhez férnek hozzá.
TODO: használati eset diagramok

### Felületi tervek, oldalvázlatok

Az alábbi képek szemléltetik az alkalmazás felületének terveit.
TODO: felületi tervek (nem fontos annyira)

### Kliensoldali szolgáltatások

TODO: szolgáltatások **listája**

### Egy funkció leírása

TODO: mi történik a kattintástól a megjelenítésig egy esetben?

### Felhasználói dokumentáció

TODO: felhasználói dokumentáció

#### Az alkalmazás ismertetése



#### Rendszerkövetelmények



#### A használat módja



##### Igénybe vehető szolgálgatások



#### Hibák oka és elkerülése



#### Példa a használatra

(képekkel)