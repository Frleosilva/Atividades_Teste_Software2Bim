# Discussão e evidências
A consulta ao repositório verifica persistência, enquanto conferir somente o retorno do serviço pode aceitar um objeto nunca salvo. Flush envia alterações ao H2; clear remove entidades do cache de primeiro nível antes da releitura.
@Transactional desfaz normalmente a transação de cada teste, isolando registros. IDs não precisam reiniciar em 1.
MockMvc percorre Controller, Service, Repository e H2 reais, usando o contexto web sem abrir um servidor HTTP. Um teste unitário com mocks não verifica essas integrações. Nenhum mock substitui serviço ou repositório.
Executar: mvn test. Os logs reais estão em evidencias na raiz. Remoção foi acrescentada para a atividade complementar dos slides.
