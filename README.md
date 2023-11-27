# entregador_controle
Controle de entregadores.
### API para gerenciamento de Entregadores

## Instruções para colocar em operação

# Requisitos
- Java 17
- PostgreSQL
  - Database: controle_entregador
  - Username: postgres
  - Password: 123456

# Instalação
- Clone este projeto
- Importe para o Eclipse
- Atualize as bibliotecas com o Maven
- Inicialize

# Acesso
- Abra o um gerenciador de API, como o Postman

# Utilização

Para incluir um entregador
	
	- URI: http://localhost:8080/entregador
	
	- Método: POST
	
	- Formulário JSON: cpf, nome, capacidadeVeiculo
	
Para listar todos os entregadores
	
	- URI: http://localhost:8080/entregador
	
	- Método: GET
	
Para mostrar apenas um entregadores
	
	- URI: http://localhost:8080/entregador/{id}
	
	- Método: GET
	
Para excluir um entregadores
	
	- URI: http://localhost:8080/entregador/{id}
	
	- Método: DELETE

Para alterar um entregadores
	
	- URI: http://localhost:8080/entregador/{id}
	
	- Método: PUT
	
	- Formulário JSON: cpf, nome, capacidadeVeiculo
