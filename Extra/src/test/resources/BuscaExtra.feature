Feature: Compra no site Submarino
  Scenario: Busca por Produto
    Given que acesso o site do Submarino
    When preencho o termo "smartphone" e clico na Lupa
    Then exibe a lista de produtos 
    
    
   Scenario: Busca por Produto N�o Encontrado
   Given que acesso o site do Submarino
   When preencho o termo "QWEQWEQWE" e clico na Lupa
   Then exibe a mensagem de produto nao encontrado