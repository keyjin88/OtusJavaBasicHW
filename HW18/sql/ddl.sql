create table if not exists question
(
    id      serial
        constraint question_pk
            primary key,
    number  integer unique        not null,
    text    varchar               not null,
    is_hard boolean default false not null --поле для выделения вопросов со звездочкой
);

create table answers
(
    id       serial
        constraint answers_pk
            primary key,
    text     varchar               not null,
    is_right boolean default false not null
);

alter table answers
    add question_number int;

alter table answers
    add constraint answers_question_number_fk
        foreign key (question_number) references question (number)
            on delete cascade;


insert into question (number, text)
values (1, 'Сколько будет 1+1?');
insert into answers (question_number, text, is_right)
values (1, '2.', true);
insert into answers (question_number, text, is_right)
values (1, 'Смотря в какой системе счисления.', false);
insert into answers (question_number, text, is_right)
values (1, '1 - я люблю JavaScript!', false);


insert into question (number, text)
values (2, 'Как зовут глухого кролика?');
insert into answers (question_number, text, is_right)
values (2, 'Банни.', false);
insert into answers (question_number, text, is_right)
values (2, 'Роджер.', false);
insert into answers (question_number, text, is_right)
values (2, 'Эй ты!', false);
insert into answers (question_number, text, is_right)
values (2, 'КРООООЛИК!!!!', true);

insert into question (number, text)
values (3, 'Windows must die?');
insert into answers (question_number, text, is_right)
values (3, 'Да.', false);
insert into answers (question_number, text, is_right)
values (3, 'Да!!!', false);
insert into answers (question_number, text, is_right)
values (3, 'Yes!', false);
insert into answers (question_number, text, is_right)
values (3, 'Да но XP был неплох.', true);