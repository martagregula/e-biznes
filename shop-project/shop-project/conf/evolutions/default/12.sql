# --- !Ups

INSERT INTO category(name, description)
VALUES ('kawa ziarnista', ''),
       ('kawa mielona', ''),
       ('kawa w kapsułkach', '');

INSERT INTO product (name, description, categoryId, price, weight, height, width)
VALUES ('KAWA ZIARNISTA STORY WILD COFFEE KOLUMBIA FINCA EL MIRADOR 250G',
        'Story Wild Coffee Kolumbia Finca el Mirador to kawa ziarnista o wspaniałym smaku, która nie posiada nadmiernej goryczy i kwasowości. Możemy wyczuć przyjemną słodycz z nutami owoców i orzechów',
        1, 79, 250, 100, 200),
       ('KAWA ZIARNISTA ETNO CAFE COLOMBIA MEDELLIN 1KG',
       'W kawie Colombia Medellin wyczuwalna w smaku jest owoców cytrusowych, którą dopełnia posmak czekolady deserowej. Takie połączenie smakuje fantastycznie oraz urzeka nas swoim aromatem.',
       1, 95, 1000, 200, 300),
       ('KAWA ZIARNISTA MOTT COFFEE COTO BRUS NATURAL 250G',
       'Kawa ziarnista Mott Coffee Coto Brus Natural jest przeznaczona dla miłośników orzeźwiających smaków. Przygotowane espresso posiada przyjemny owocowy smak z wyczuwalną nutą czereśni.',
       1, 35, 250, 150, 100),
       ('KAWA W KAPSUŁKACH COSTA COFFEE SIGNATURE BLEND ESPRESSO 16 SZT.',
       'Kawa w kapsułkach Costa Coffee Signature Blend Espresso posiada przyjemny, idealnie zbalansowany smak. Możemy wyczuć w niej nuty orzechów laskowych i mlecznej czekolady. Jest to kawa polecana do przygotowania w formie intensywnego, aromatycznego espresso.',
        3, 19, 112, 100, 100),
       ('KAPSUŁKI DO NESPRESSO STARBUCKS® HOUSE BLEND 3X10 SZTUK',
        'Kawa w kapsułkach Nespresso Starbucks House Blend posiada zrównoważony smak z wyczuwalną słodką nutą kakao.',
        3, 50, 190, 150, 100),
       ('KAWA MIELONA CAFFE DEL FARO GOLD EXTRA BAR 250G',
        'Kawa Gold Extra Bar to intensywne połączenie arabiki i robusty, zawierające najlepsze cechy obu rodzajów kaw. W pierwszej chwili pojawia się tutaj zaskakująca kompozycja mlecznej czekolady oraz owoców, która w późniejszej fazie przechodzi w subtelne kwaskowato-goryczkowe nuty charakterystyczne dla robusty.',
        2, 27, 250, 200, 150),
        ('KAWA MIELONA LAVAZZA CREMA E GUSTO DOLCE/DELICATO 250G',
        'Kawa jest bardzo łagodna w smaku z wyczuwalną nutą wanilii.',
        2, 19, 250, 200, 150),
        ('KAWA MIELONA PLUTON BLACK 250G',
        'Pluton Black to dosyć intensywna kawa, w której praktycznie nie wyczujemy żadnej kwasowości. Po odpowiednim zaparzeniu kawa ukaże przed nami nuty gorzkiej czekolady, kakao i migdałów.',
         2, 29, 250, 200, 150);

# --- !Downs