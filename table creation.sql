-- Table: student_info

-- DROP TABLE student_info;

CREATE TABLE student_info
(
  student_id serial NOT NULL,
  student_name character varying(100),
  student_age character varying(5),
  student_address character varying(255),
  CONSTRAINT student_info_pkey PRIMARY KEY (student_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE student_info
  OWNER TO postgres;
  
  
  
  
  -- joining tables the correct way
  
  
-- Table: tbl_image

-- DROP TABLE tbl_image;

CREATE TABLE tbl_image
(
  name character varying,
  path character varying,
  id_image integer NOT NULL,
  CONSTRAINT tbl_image_pkey PRIMARY KEY (id_image)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tbl_image
  OWNER TO postgres;  
  
  
  
  
  
-- Table: tbl_imagedetails

-- DROP TABLE tbl_imagedetails;

CREATE TABLE tbl_imagedetails
(
  comment character varying,
  id_details integer NOT NULL,
  CONSTRAINT tbl_imagedetails_pkey PRIMARY KEY (id_details)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tbl_imagedetails
  OWNER TO postgres;
  
  
  
  
  
  
  
-- Table: tbl_imageinfo

-- DROP TABLE tbl_imageinfo;

CREATE TABLE tbl_imageinfo
(
  id_image integer,
  id_details integer
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tbl_imageinfo
  OWNER TO postgres;
  
  
    -- joining tables the correct way
  
  
  
  
  
  
  
  
  
  
  
insert into tbl_image (name,path,id_image) values ('johnrheyimage','c:folder2',2);
insert into tbl_image (name,path,id_image) values ('jayimage','c:folder',1);

insert into tbl_imagedetails (id_details,comment) values (1,'pangit');
insert into tbl_imagedetails (id_details,comment) values (2,'hahahaha');
insert into tbl_imagedetails (id_details,comment) values (3,'mejo pogi na');

insert into tbl_imagedetails (id_details,comment) values (4,'wow');
insert into tbl_imagedetails (id_details,comment) values (5,'hamoizing');

insert into tbl_imageinfo (id_image,id_details) values (1,1);
insert into tbl_imageinfo (id_image,id_details) values (1,2);
insert into tbl_imageinfo (id_image,id_details) values (1,3);

insert into tbl_imageinfo (id_image,id_details) values (2,4);
insert into tbl_imageinfo (id_image,id_details) values (2,5);

select * from tbl_image;
select * from tbl_imagedetails;
select * from tbl_imageinfo;


select i.name,i.path,id.comment from tbl_image i, tbl_imagedetails id, tbl_imageinfo ii
where i.id_image = ii.id_image and id.id_details = ii.id_details;
