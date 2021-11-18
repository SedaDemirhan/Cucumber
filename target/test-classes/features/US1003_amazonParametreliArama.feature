@Paralel2

Feature: US1003 kullanici istedigi kelime icin arama yapip, sonucu test eder

  @rapor2
  Scenario: TC07 istenen kelimenin oldugunu test etme
    Given kullanici "amazonUrl" sayfasina gider
    And "armut" icin arama yapar
    Then sonucun "armut" icerdigini test eder
    And sayfayi kapatir

    #parametre olarak yazdığımız kelimeyi stepdefinition'da String olarak kullanacaksa
    #ne yazdığımız önemli değil "armut" gibi

    #ancak eğer parametre olarak yazdığımız kelimey, configration properties den alcaksak
    #burada yazdığımız parametrenin configration.properties'deki yazım ile aynı olması gerekir
    #"amazonUrl" gibi,eğer yazım farklı olursa nullPointerException verir

    #buradki parametre ile configrationProperties aynı olduktan sonra
    #stepdefinition da parametre olarak ne yazdığımızın önemi olmaz