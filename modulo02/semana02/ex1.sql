create schema university;

create table university.alunos(
	mat_alu int not null,
  	nome varchar(100) not null,
  	dat_entrada date not null,
  	cod_curso int not null,
  	cotista char(1) not null,
  	primary key (mat_alu)
);

create table university.matriculas(
	semestre int not null,
  	mat_alu int not null,
  	cod_disc int not null,
  	nota numeric(5,2),
  	faltas int,
  	status char(1),
  	primary key (mat_alu, semestre)
);

create table university.cursos(
	cod_curso int not null,
  	nom_curso varchar(80) not null,
  	cod_dpto int not null,
  	primary key (cod_curso)
);

create table university.disciplinas(
	cod_disc int not null,
  	nom_disc varchar(60) not null,
  	carga_horaria numeric(5,2) not null,
  	primary key (cod_disc)
);

create table university.departamentos(
	cod_dpto int not null,
  	nom_dpto varchar(50) not null,
  	primary key (cod_dpto)
);

create table university.matrizes_cursos(
	cod_curso int not null,
  	cod_disc int not null,
  	periodo int not null,
  	primary key (cod_curso, cod_disc)
);