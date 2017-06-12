
-- 删除同名表--
drop table if exists t_user;

# 创建user表
create table t_user(
   id int primary key,
   username varchar(32)  not null,
   password varchar(38) not null,
   station varchar(32),
   telephone varchar(20),
   remark varchar(99)
);

# 创建staff表
create table t_staff(
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(26) not null,
   telephone VARCHAR(22),
   haspda VARCHAR(1),
   deltag VARCHAR(1),
   station VARCHAR(32)
);

# 创建区域表
CREATE TABLE t_region(
   id INT PRIMARY KEY AUTO_INCREMENT,
   priovince VARCHAR(32),
   city VARCHAR(32),
   district VARCHAR(32),
   postcode VARCHAR(18),
   shortcode VARCHAR(20),
   citycode VARCHAR(22)
);

# 分区表
CREATE TABLE t_subarea(
   id INT PRIMARY KEY AUTO_INCREMENT,
   decidedzone_id INT,
   region_id INT,
   addresskey VARCHAR(32),
   startnum VARCHAR(12),
   endnum VARCHAR(12),
   single VARCHAR(18),
   position VARCHAR(32),
   CONSTRAINT fk_dz_sub FOREIGN KEY(decidedzone_id) REFERENCES t_decidedzone(id),
   CONSTRAINT fk_reg_sub FOREIGN KEY(region_id) REFERENCES t_region(id)
);

# 定区表
CREATE TABLE t_decidedzone(
   id INT PRIMARY KEY AUTO_INCREMENT,
   staff_id INT,
   name VARCHAR(38),
   CONSTRAINT fk_staf_dz FOREIGN KEY(staff_id) REFERENCES t_staff(id)
);

#权限表
CREATE TABLE t_function(
   id INT PRIMARY KEY,
   name VARCHAR(30) NOT NULL ,
   code VARCHAR(30) NOT NULL ,
   description VARCHAR(100),
   page VARCHAR(88),
   generatemeun TINYINT NOT NULL ,
   zindex TINYINT,
   pid INT
);

INSERT INTO t_function VALUES (1,'基础数据','base_data',NULL,NULL,1,0,NULL);
INSERT INTO t_function VALUES (12,'取派员设置','staff_set',NULL,'/WEB-INF/views/base/staff',1,1,1);
INSERT INTO t_function VALUES (13,'区域设置','region_set',NULL,'/WEB-INF/views/base/region',1,2,1);
INSERT INTO t_function VALUES (14,'管理分区','subarea_set',NULL,'/WEB-INF/views/base/subarea',1,3,1);
INSERT INTO t_function VALUES (15,'管理定区调度排班','dz_set',NULL,'/WEB-INF/views/base/decidedzone',1,4,1);



