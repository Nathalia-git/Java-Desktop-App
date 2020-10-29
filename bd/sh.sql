create table cliente(
	codCliente char(7) not null primary key,
    nomeCliente varchar(50) not null,
    rgCliente char(7) not null,
    bairroCliente varchar(20),
    cidadeCliente varchar(20),
    estadoCliente char(2),
    CEPCliente char(8),
    NascimentoCliente date
);

create table chale(
	codChale char (7) not null primary key,
    localizacao varchar(30),
    capacidade int, 
    valorAltaEstacao decimal (8,2),
    valorBaixaEstacao decimal (8,2)
);

create table hospedagem(
	codHospedagem char(7) not null primary key,
    codChale char(7) not null,
    estado char(2),
    dataInicio date,
    dataFim date,
    qtdPessoas int,
    desconto decimal(6,2),
    valorFinal decimal(8,2),
    constraint fk_hospedagem_chale foreign key (codChale) references chale(codChale)
);
