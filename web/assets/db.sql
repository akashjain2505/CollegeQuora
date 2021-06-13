create database collegeweb;

create table collegeweb.user(
    uid int AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    mail  varchar(100) NOT NULL UNIQUE,
    phone varchar(20) UNIQUE,
    password varchar(10) NOT NULL,
    type int NOT NULL, /* Faculty-1 Student-2 */
    branch int NOT NULL, /* CS-1, EC-2 ME-3 */
    otp int,
    isVerify int default 0, /* Not Verified -0 Verified - 1*/   
    PRIMARY KEY (uid)
);

create table collegeweb.question(
    qid int AUTO_INCREMENT,
    qus varchar(5000) NOT NULL,
    qus_date timestamp default CURRENT_TIMESTAMP,
    ask_by int,
    PRIMARY KEY (qid),
    FOREIGN KEY (ask_by) REFERENCES collegeweb.user(uid)
);

create table collegeweb.answer(
    aid int AUTO_INCREMENT,
    ans varchar(5000) NOT NULL,
    ans_date timestamp default CURRENT_TIMESTAMP,
    qus int,
    ans_by int,
    PRIMARY KEY (aid),
    FOREIGN KEY (qus) REFERENCES collegeweb.question(qid),
    FOREIGN KEY (ans_by) REFERENCES collegeweb.user(uid)
);
