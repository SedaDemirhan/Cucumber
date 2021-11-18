
  Feature: GMIBank Güvenli sifre
    Background:
      Given kullanici gmibank sayfasina gider
      Then gmibank giris butonuna tiklar
      Then gmibank register butonuna tiklar
      And gmibank password kutusuna tiklar

    Scenario Outline: Password Red Test
      Given "<password>"girer
      Then gmibank Password strength red gorunur

      Examples:
      |password|
      |1111    |
      |AAAA    |

    Scenario Outline: Password Orange Test
      Given "<passwordOrange>"girer
      Then gmibank Password strength orange gorunur

      Examples:
        |passwordOrange|
        |11AA    |
        |AA22    |

    Scenario Outline: Password yellow Test
      Given "<passwordYellow>"girer
      Then gmibank Password strength yellow gorunur

      Examples:
        |passwordYellow|
        |11AAaa    |
        |AA22aa    |

    Scenario Outline: Password LightGreen Test
      Given "<passwordLightGreen>"girer
      Then gmibank Password strength LightGreen gorunur

      Examples:
        |passwordLightGreen|
        |1Aa+    |
        |A2a+    |

    Scenario Outline: Password Green Test
      Given "<passwordGreen>"girer
      Then gmibank Password strength Green gorunur

      Examples:
        |passwordGreen|
        |11AA.    |
        |AA22.   |