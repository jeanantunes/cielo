DROP TABLE IF EXISTS totalControleLancamento;
CREATE TABLE totalControleLancamento(
  id INT PRIMARY KEY,
  quantidadeLancamentos NUMERIC NOT NULL,
  quantidadeRemessas NUMERIC NOT NULL,
  valorLancamentos BIGINT NOT NULL
);

DROP TABLE IF EXISTS lancamentoContaCorrenteCliente;
CREATE TABLE lancamentoContaCorrenteCliente(
  id INT PRIMARY KEY,
  numeroRemessaBanco BIGINTEGER NOT NULL,
  nomeSituacaoRemessa VARCHAR(50) NULL
  --dadosDomicilioBancario INTEGER NULL,
  nomeTipoOperacao VARCHAR(50)
);

DROP TABLE IF EXISTS dadosDomicilioBancario;
CREATE TABLE dadosDomicilioBancario(
  id INT PRIMARY KEY,
  codigoBanco NUMERIC NOT NULL,
  numeroAgencia NUMERIC NOT NULL,
  numeroContaCorrente VARCHAR(20)
  --lancamentoContaCorrenteCliente INTEGER NULL
);

DROP TABLE IF EXISTS listaControleLancamento;
CREATE TABLE listaControleLancamento(
  id INT PRIMARY KEY,
  lancamentoContaCorrenteCliente INT NOT NULL,
  dataEfetivaLancamento VARCHAR(10) NOT NULL,
  dataLancamentoContaCorrenteCliente VARCHAR(10) NOT NULL,
  numeroEvento INTEGER NOT NULL,
  descricaoGrupoPagamento VARCHAR(5),
  codigoIdentificadorUnico VARCHAR(1) NOT NULL,
  nomeBanco VARCHAR(50) NOT NULL,
  quantidadeLancamentoRemessa NUMBER NOT NULL,
  numeroRaizCNPJ VARCHAR(50) NOT NULL,
  numeroSufixoCNPJ VARCHAR(50) NOT NULL,
  valorLancamentoRemessa NUMERIC NOT NULL,
  dateLancamentoContaCorrenteCliente DATE NOT NULL,
  dateEfetivaLancamento DATE NOT NULL
);

ALTER TABLE lancamentoContaCorrenteCliente
  ADD FOREIGN KEY (dadosDomicilioBancario) REFERENCES dadosDomicilioBancario(id);

--ALTER TABLE PF
--ADD FOREIGN KEY (CPF) REFERENCES PESSOA(CPF);

--ALTER TABLE PJ
--ADD FOREIGN KEY (CNPJ) REFERENCES PESSOA(CNPJ);

--ALTER TABLE PESSOA
--ADD FOREIGN KEY (CONTA_ID) REFERENCES CONTA(CONTA_ID);

--ALTER TABLE MOVIMENTACAO
--  ADD FOREIGN KEY (CONTA_ID) REFERENCES CONTA(ID);


INSERT INTO totalControleLancamento VALUES (1,608,39,473320.37);
INSERT INTO totalControleLancamento VALUES (2,700,43,3210.22);

--INSERT INTO CONTA VALUES (1, 'CONTA 1', 'PF', 'M', 'A', 1);
--INSERT INTO CONTA VALUES (2, 'CONTA 2', 'PJ', 'M', 'A', 2);

--INSERT INTO PF VALUES (1,'Jean Antunes','22842388828','1987-06-07');
--INSERT INTO PJ VALUES (1,'Jota IT Services Ltda - ME','Jota IT Services','28466095000152');

--INSERT INTO MOVIMENTACAO VALUES (1,1,1000,200,800,1);
--INSERT INTO MOVIMENTACAO VALUES (2,2,2000,400,800,2);