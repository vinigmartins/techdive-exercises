alter table university.alunos
add constraint cod_curso foreign key (cod_curso) references university.cursos (cod_curso);

alter table university.cursos
add constraint cod_dpto foreign key (cod_dpto) references university.departamentos (cod_dpto);

alter table university.matriculas
add constraint mat_alu foreign key (mat_alu) references university.alunos (mat_alu);

alter table university.matriculas
add constraint cod_disc foreign key (cod_disc) references university.disciplinas (cod_disc);

alter table university.matrizes_cursos
add constraint cod_disc foreign key (cod_disc) references university.disciplinas (cod_disc);

alter table university.matrizes_cursos
add constraint cod_curso foreign key (cod_curso) references university.cursos (cod_curso);