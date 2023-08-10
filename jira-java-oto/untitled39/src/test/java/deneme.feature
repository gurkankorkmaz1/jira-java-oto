Feature: Sepete Urun Ekleme Testi

  Scenario: Kitapyurdu sitesine git ve istenen kategorideki kitabı sepete ekleyip sepet kontrolu yap

    Given Kitapyurdu sitesine git
    And cerezleri kabul et
    And cok satan kitaplar sekmesinin uzerine gel
    And cok satan edebiyat kitaplari uzerine tikla
    And bir ve yirmi arasi random bir kitaba tikla
    And secilen kitabi sepete ekle
    When sepete tikla
    Then sepete git butonuna tikla

