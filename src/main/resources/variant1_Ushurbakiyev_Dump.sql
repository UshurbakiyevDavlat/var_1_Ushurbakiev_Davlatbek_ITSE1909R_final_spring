--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0
-- Dumped by pg_dump version 14.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: variant1_Ushurbakiyev; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "variant1_Ushurbakiyev" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';


ALTER DATABASE "variant1_Ushurbakiyev" OWNER TO postgres;

\connect "variant1_Ushurbakiyev"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: variant1_Ushurbakiyev; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA "variant1_Ushurbakiyev";


ALTER SCHEMA "variant1_Ushurbakiyev" OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: addresses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.addresses (
    id integer NOT NULL,
    name character varying(50)
);


ALTER TABLE public.addresses OWNER TO postgres;

--
-- Name: addresses_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.addresses_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.addresses_id_seq OWNER TO postgres;

--
-- Name: addresses_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.addresses_id_seq OWNED BY public.addresses.id;


--
-- Name: bill_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bill_details (
    id integer NOT NULL,
    lab_cost integer,
    doctor_cost integer,
    insurance integer,
    additional_pay integer
);


ALTER TABLE public.bill_details OWNER TO postgres;

--
-- Name: bill_details_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.bill_details_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.bill_details_id_seq OWNER TO postgres;

--
-- Name: bill_details_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.bill_details_id_seq OWNED BY public.bill_details.id;


--
-- Name: bills; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bills (
    id integer NOT NULL,
    user_id integer,
    bill_detail_id integer,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone,
    deleted_at timestamp without time zone
);


ALTER TABLE public.bills OWNER TO postgres;

--
-- Name: bills_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.bills_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.bills_id_seq OWNER TO postgres;

--
-- Name: bills_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.bills_id_seq OWNED BY public.bills.id;


--
-- Name: health_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.health_history (
    id integer NOT NULL,
    title character varying(100),
    user_id integer,
    doctor_id integer,
    status integer,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone,
    deleted_at timestamp without time zone
);


ALTER TABLE public.health_history OWNER TO postgres;

--
-- Name: COLUMN health_history.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.health_history.status IS '0 - не лечится в настоящее время
1 - лечится';


--
-- Name: health_history_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.health_history_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.health_history_id_seq OWNER TO postgres;

--
-- Name: health_history_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.health_history_id_seq OWNED BY public.health_history.id;


--
-- Name: lab_reports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lab_reports (
    id integer NOT NULL,
    health_id integer,
    doctor_id integer,
    blood character varying(100),
    heart character varying(100),
    body character varying(100),
    vision character varying(100),
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone,
    deleted_at timestamp without time zone
);


ALTER TABLE public.lab_reports OWNER TO postgres;

--
-- Name: lab_reports_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.lab_reports_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.lab_reports_id_seq OWNER TO postgres;

--
-- Name: lab_reports_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.lab_reports_id_seq OWNED BY public.lab_reports.id;


--
-- Name: permissions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.permissions (
    id integer NOT NULL,
    role_id integer,
    perm_interact_patients integer,
    perm_access_health_history integer,
    perm_redact integer,
    perm_delete integer,
    perm_view integer
);


ALTER TABLE public.permissions OWNER TO postgres;

--
-- Name: permissions_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.permissions_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.permissions_id_seq OWNER TO postgres;

--
-- Name: permissions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.permissions_id_seq OWNED BY public.permissions.id;


--
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    title character varying(50) NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    login character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp without time zone,
    deleted_at timestamp without time zone,
    role_id integer,
    age integer,
    address integer,
    status integer
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: bill_details; Type: TABLE; Schema: variant1_Ushurbakiyev; Owner: postgres
--

CREATE TABLE "variant1_Ushurbakiyev".bill_details (
    id integer NOT NULL,
    lab_cost integer,
    doctor_cost integer,
    insurance integer,
    additional_pay integer
);


ALTER TABLE "variant1_Ushurbakiyev".bill_details OWNER TO postgres;

--
-- Name: bill_details_id_seq; Type: SEQUENCE; Schema: variant1_Ushurbakiyev; Owner: postgres
--

CREATE SEQUENCE "variant1_Ushurbakiyev".bill_details_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "variant1_Ushurbakiyev".bill_details_id_seq OWNER TO postgres;

--
-- Name: bill_details_id_seq; Type: SEQUENCE OWNED BY; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER SEQUENCE "variant1_Ushurbakiyev".bill_details_id_seq OWNED BY "variant1_Ushurbakiyev".bill_details.id;


--
-- Name: bills; Type: TABLE; Schema: variant1_Ushurbakiyev; Owner: postgres
--

CREATE TABLE "variant1_Ushurbakiyev".bills (
    id integer NOT NULL,
    user_id integer,
    bill_detail_id integer,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone,
    deleted_at timestamp without time zone
);


ALTER TABLE "variant1_Ushurbakiyev".bills OWNER TO postgres;

--
-- Name: bills_id_seq; Type: SEQUENCE; Schema: variant1_Ushurbakiyev; Owner: postgres
--

CREATE SEQUENCE "variant1_Ushurbakiyev".bills_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "variant1_Ushurbakiyev".bills_id_seq OWNER TO postgres;

--
-- Name: bills_id_seq; Type: SEQUENCE OWNED BY; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER SEQUENCE "variant1_Ushurbakiyev".bills_id_seq OWNED BY "variant1_Ushurbakiyev".bills.id;


--
-- Name: health_history; Type: TABLE; Schema: variant1_Ushurbakiyev; Owner: postgres
--

CREATE TABLE "variant1_Ushurbakiyev".health_history (
    id integer NOT NULL,
    title character(100),
    user_id integer,
    doctor_id integer,
    status integer,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone,
    deleted_at timestamp without time zone
);


ALTER TABLE "variant1_Ushurbakiyev".health_history OWNER TO postgres;

--
-- Name: COLUMN health_history.status; Type: COMMENT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

COMMENT ON COLUMN "variant1_Ushurbakiyev".health_history.status IS '0 - не лечится в настоящее время
1 - лечится';


--
-- Name: health_history_id_seq; Type: SEQUENCE; Schema: variant1_Ushurbakiyev; Owner: postgres
--

CREATE SEQUENCE "variant1_Ushurbakiyev".health_history_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "variant1_Ushurbakiyev".health_history_id_seq OWNER TO postgres;

--
-- Name: health_history_id_seq; Type: SEQUENCE OWNED BY; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER SEQUENCE "variant1_Ushurbakiyev".health_history_id_seq OWNED BY "variant1_Ushurbakiyev".health_history.id;


--
-- Name: lab_reports; Type: TABLE; Schema: variant1_Ushurbakiyev; Owner: postgres
--

CREATE TABLE "variant1_Ushurbakiyev".lab_reports (
    id integer NOT NULL,
    health_id integer,
    doctor_id integer,
    blood character varying(100),
    heart character varying(100),
    body character varying(100),
    vision character varying(100),
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone,
    deleted_at timestamp without time zone
);


ALTER TABLE "variant1_Ushurbakiyev".lab_reports OWNER TO postgres;

--
-- Name: lab_reports_id_seq; Type: SEQUENCE; Schema: variant1_Ushurbakiyev; Owner: postgres
--

CREATE SEQUENCE "variant1_Ushurbakiyev".lab_reports_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "variant1_Ushurbakiyev".lab_reports_id_seq OWNER TO postgres;

--
-- Name: lab_reports_id_seq; Type: SEQUENCE OWNED BY; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER SEQUENCE "variant1_Ushurbakiyev".lab_reports_id_seq OWNED BY "variant1_Ushurbakiyev".lab_reports.id;


--
-- Name: permissions; Type: TABLE; Schema: variant1_Ushurbakiyev; Owner: postgres
--

CREATE TABLE "variant1_Ushurbakiyev".permissions (
    id integer NOT NULL,
    role_id integer,
    perm_interact_patients integer,
    perm_access_health_history integer,
    perm_redact integer,
    perm_delete integer,
    perm_view integer
);


ALTER TABLE "variant1_Ushurbakiyev".permissions OWNER TO postgres;

--
-- Name: permissions_id_seq; Type: SEQUENCE; Schema: variant1_Ushurbakiyev; Owner: postgres
--

CREATE SEQUENCE "variant1_Ushurbakiyev".permissions_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "variant1_Ushurbakiyev".permissions_id_seq OWNER TO postgres;

--
-- Name: permissions_id_seq; Type: SEQUENCE OWNED BY; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER SEQUENCE "variant1_Ushurbakiyev".permissions_id_seq OWNED BY "variant1_Ushurbakiyev".permissions.id;


--
-- Name: roles; Type: TABLE; Schema: variant1_Ushurbakiyev; Owner: postgres
--

CREATE TABLE "variant1_Ushurbakiyev".roles (
    id integer NOT NULL,
    title character(50) NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE "variant1_Ushurbakiyev".roles OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE; Schema: variant1_Ushurbakiyev; Owner: postgres
--

CREATE SEQUENCE "variant1_Ushurbakiyev".roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "variant1_Ushurbakiyev".roles_id_seq OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER SEQUENCE "variant1_Ushurbakiyev".roles_id_seq OWNED BY "variant1_Ushurbakiyev".roles.id;


--
-- Name: users; Type: TABLE; Schema: variant1_Ushurbakiyev; Owner: postgres
--

CREATE TABLE "variant1_Ushurbakiyev".users (
    id integer NOT NULL,
    login character(50) NOT NULL,
    password character(50) NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp without time zone,
    deleted_at timestamp without time zone,
    role_id integer,
    age integer,
    address character varying(50),
    status integer
);


ALTER TABLE "variant1_Ushurbakiyev".users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: variant1_Ushurbakiyev; Owner: postgres
--

CREATE SEQUENCE "variant1_Ushurbakiyev".users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "variant1_Ushurbakiyev".users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER SEQUENCE "variant1_Ushurbakiyev".users_id_seq OWNED BY "variant1_Ushurbakiyev".users.id;


--
-- Name: addresses id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.addresses ALTER COLUMN id SET DEFAULT nextval('public.addresses_id_seq'::regclass);


--
-- Name: bill_details id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bill_details ALTER COLUMN id SET DEFAULT nextval('public.bill_details_id_seq'::regclass);


--
-- Name: bills id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills ALTER COLUMN id SET DEFAULT nextval('public.bills_id_seq'::regclass);


--
-- Name: health_history id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.health_history ALTER COLUMN id SET DEFAULT nextval('public.health_history_id_seq'::regclass);


--
-- Name: lab_reports id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lab_reports ALTER COLUMN id SET DEFAULT nextval('public.lab_reports_id_seq'::regclass);


--
-- Name: permissions id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permissions ALTER COLUMN id SET DEFAULT nextval('public.permissions_id_seq'::regclass);


--
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Name: bill_details id; Type: DEFAULT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".bill_details ALTER COLUMN id SET DEFAULT nextval('"variant1_Ushurbakiyev".bill_details_id_seq'::regclass);


--
-- Name: bills id; Type: DEFAULT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".bills ALTER COLUMN id SET DEFAULT nextval('"variant1_Ushurbakiyev".bills_id_seq'::regclass);


--
-- Name: health_history id; Type: DEFAULT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".health_history ALTER COLUMN id SET DEFAULT nextval('"variant1_Ushurbakiyev".health_history_id_seq'::regclass);


--
-- Name: lab_reports id; Type: DEFAULT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".lab_reports ALTER COLUMN id SET DEFAULT nextval('"variant1_Ushurbakiyev".lab_reports_id_seq'::regclass);


--
-- Name: permissions id; Type: DEFAULT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".permissions ALTER COLUMN id SET DEFAULT nextval('"variant1_Ushurbakiyev".permissions_id_seq'::regclass);


--
-- Name: roles id; Type: DEFAULT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".roles ALTER COLUMN id SET DEFAULT nextval('"variant1_Ushurbakiyev".roles_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".users ALTER COLUMN id SET DEFAULT nextval('"variant1_Ushurbakiyev".users_id_seq'::regclass);


--
-- Data for Name: addresses; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.addresses (id, name) VALUES (1, 'Sanatornaya13a');
INSERT INTO public.addresses (id, name) VALUES (2, 'testoviyAddress');
INSERT INTO public.addresses (id, name) VALUES (4, 'TEst2');
INSERT INTO public.addresses (id, name) VALUES (5, 'TEst3');
INSERT INTO public.addresses (id, name) VALUES (6, 'TEst4');
INSERT INTO public.addresses (id, name) VALUES (7, 'TEst5');
INSERT INTO public.addresses (id, name) VALUES (8, 'TEst6');
INSERT INTO public.addresses (id, name) VALUES (3, 'TEst1');


--
-- Data for Name: bill_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.bill_details (id, lab_cost, doctor_cost, insurance, additional_pay) VALUES (4, NULL, NULL, 15000, NULL);
INSERT INTO public.bill_details (id, lab_cost, doctor_cost, insurance, additional_pay) VALUES (5, NULL, NULL, 15000, NULL);
INSERT INTO public.bill_details (id, lab_cost, doctor_cost, insurance, additional_pay) VALUES (6, NULL, NULL, 15000, NULL);


--
-- Data for Name: bills; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.bills (id, user_id, bill_detail_id, created_at, updated_at, deleted_at) VALUES (1, 8, 4, '2022-05-12 17:18:06.926', NULL, NULL);
INSERT INTO public.bills (id, user_id, bill_detail_id, created_at, updated_at, deleted_at) VALUES (2, 8, 4, '2022-05-13 19:04:46.551', NULL, NULL);
INSERT INTO public.bills (id, user_id, bill_detail_id, created_at, updated_at, deleted_at) VALUES (3, 8, 4, '2022-05-15 15:05:46.003', NULL, NULL);


--
-- Data for Name: health_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.health_history (id, title, user_id, doctor_id, status, created_at, updated_at, deleted_at) VALUES (5, 'TestHealthCard3', 8, 6, 1, '2022-05-15 15:05:04.392', NULL, NULL);
INSERT INTO public.health_history (id, title, user_id, doctor_id, status, created_at, updated_at, deleted_at) VALUES (4, 'TestHealthCard2', 8, 6, 1, '2022-05-13 19:04:27.909', NULL, NULL);
INSERT INTO public.health_history (id, title, user_id, doctor_id, status, created_at, updated_at, deleted_at) VALUES (2, 'TestHealthCard', 8, 6, 0, '2022-05-12 16:13:39.695', NULL, NULL);


--
-- Data for Name: lab_reports; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: permissions; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.roles (id, title, created_at, updated_at) VALUES (1, 'Admin', '2022-05-09 15:31:54', '2022-05-09 15:31:57');
INSERT INTO public.roles (id, title, created_at, updated_at) VALUES (3, 'Guest', '2022-05-09 15:32:17', '2022-05-09 09:32:19.234284');
INSERT INTO public.roles (id, title, created_at, updated_at) VALUES (2, 'Doctor', '2022-05-09 15:32:08', '2022-05-09 15:32:11');


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (id, login, password, created_at, updated_at, deleted_at, role_id, age, address, status) VALUES (11, 'newTestLogin', 'newTestpassword', '2022-05-15 15:19:33.262', '2022-05-15 15:19:33.310386', NULL, 1, 22, 2, 1);
INSERT INTO public.users (id, login, password, created_at, updated_at, deleted_at, role_id, age, address, status) VALUES (6, 'newTestLogin', 'newTestPass2', '2022-05-09 19:00:40.947', '2022-05-13 19:03:56.257014', NULL, 1, 22, NULL, 1);
INSERT INTO public.users (id, login, password, created_at, updated_at, deleted_at, role_id, age, address, status) VALUES (8, 'newTestLogin1', 'newTestPass234', '2022-05-11 16:15:51.841', '2022-05-15 16:00:27.266147', NULL, 2, 22, 1, 1);
INSERT INTO public.users (id, login, password, created_at, updated_at, deleted_at, role_id, age, address, status) VALUES (14, 'newTestLogin', 'newTestpassword', '2022-05-15 15:21:21.683', '2022-05-15 15:21:21.683794', NULL, 3, 22, 3, 1);
INSERT INTO public.users (id, login, password, created_at, updated_at, deleted_at, role_id, age, address, status) VALUES (16, 'test', '123', '2022-05-15 16:37:19', '2022-05-15 16:37:20', NULL, 1, 22, 4, 1);


--
-- Data for Name: bill_details; Type: TABLE DATA; Schema: variant1_Ushurbakiyev; Owner: postgres
--



--
-- Data for Name: bills; Type: TABLE DATA; Schema: variant1_Ushurbakiyev; Owner: postgres
--



--
-- Data for Name: health_history; Type: TABLE DATA; Schema: variant1_Ushurbakiyev; Owner: postgres
--



--
-- Data for Name: lab_reports; Type: TABLE DATA; Schema: variant1_Ushurbakiyev; Owner: postgres
--



--
-- Data for Name: permissions; Type: TABLE DATA; Schema: variant1_Ushurbakiyev; Owner: postgres
--



--
-- Data for Name: roles; Type: TABLE DATA; Schema: variant1_Ushurbakiyev; Owner: postgres
--



--
-- Data for Name: users; Type: TABLE DATA; Schema: variant1_Ushurbakiyev; Owner: postgres
--



--
-- Name: addresses_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.addresses_id_seq', 8, true);


--
-- Name: bill_details_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.bill_details_id_seq', 6, true);


--
-- Name: bills_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.bills_id_seq', 3, true);


--
-- Name: health_history_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.health_history_id_seq', 5, true);


--
-- Name: lab_reports_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.lab_reports_id_seq', 4, true);


--
-- Name: permissions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.permissions_id_seq', 3, true);


--
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_seq', 3, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 16, true);


--
-- Name: bill_details_id_seq; Type: SEQUENCE SET; Schema: variant1_Ushurbakiyev; Owner: postgres
--

SELECT pg_catalog.setval('"variant1_Ushurbakiyev".bill_details_id_seq', 1, false);


--
-- Name: bills_id_seq; Type: SEQUENCE SET; Schema: variant1_Ushurbakiyev; Owner: postgres
--

SELECT pg_catalog.setval('"variant1_Ushurbakiyev".bills_id_seq', 1, false);


--
-- Name: health_history_id_seq; Type: SEQUENCE SET; Schema: variant1_Ushurbakiyev; Owner: postgres
--

SELECT pg_catalog.setval('"variant1_Ushurbakiyev".health_history_id_seq', 1, false);


--
-- Name: lab_reports_id_seq; Type: SEQUENCE SET; Schema: variant1_Ushurbakiyev; Owner: postgres
--

SELECT pg_catalog.setval('"variant1_Ushurbakiyev".lab_reports_id_seq', 1, false);


--
-- Name: permissions_id_seq; Type: SEQUENCE SET; Schema: variant1_Ushurbakiyev; Owner: postgres
--

SELECT pg_catalog.setval('"variant1_Ushurbakiyev".permissions_id_seq', 1, false);


--
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: variant1_Ushurbakiyev; Owner: postgres
--

SELECT pg_catalog.setval('"variant1_Ushurbakiyev".roles_id_seq', 1, false);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: variant1_Ushurbakiyev; Owner: postgres
--

SELECT pg_catalog.setval('"variant1_Ushurbakiyev".users_id_seq', 1, false);


--
-- Name: addresses addresses_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.addresses
    ADD CONSTRAINT addresses_pk PRIMARY KEY (id);


--
-- Name: bill_details bill_details_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bill_details
    ADD CONSTRAINT bill_details_pk PRIMARY KEY (id);


--
-- Name: bills bills_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT bills_pk PRIMARY KEY (id);


--
-- Name: health_history health_history_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.health_history
    ADD CONSTRAINT health_history_pk PRIMARY KEY (id);


--
-- Name: lab_reports lab_reports_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lab_reports
    ADD CONSTRAINT lab_reports_pk PRIMARY KEY (id);


--
-- Name: permissions permissions_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permissions
    ADD CONSTRAINT permissions_pk PRIMARY KEY (id);


--
-- Name: roles roles_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pk PRIMARY KEY (id);


--
-- Name: users users_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pk PRIMARY KEY (id);


--
-- Name: bill_details bill_details_pk; Type: CONSTRAINT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".bill_details
    ADD CONSTRAINT bill_details_pk PRIMARY KEY (id);


--
-- Name: bills bills_pk; Type: CONSTRAINT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".bills
    ADD CONSTRAINT bills_pk PRIMARY KEY (id);


--
-- Name: health_history health_history_pk; Type: CONSTRAINT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".health_history
    ADD CONSTRAINT health_history_pk PRIMARY KEY (id);


--
-- Name: lab_reports lab_reports_pk; Type: CONSTRAINT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".lab_reports
    ADD CONSTRAINT lab_reports_pk PRIMARY KEY (id);


--
-- Name: permissions permissions_pk; Type: CONSTRAINT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".permissions
    ADD CONSTRAINT permissions_pk PRIMARY KEY (id);


--
-- Name: roles roles_pk; Type: CONSTRAINT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".roles
    ADD CONSTRAINT roles_pk PRIMARY KEY (id);


--
-- Name: users users_pk; Type: CONSTRAINT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".users
    ADD CONSTRAINT users_pk PRIMARY KEY (id);


--
-- Name: users_address_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX users_address_uindex ON public.users USING btree (address);


--
-- Name: bills bills_bill_details_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT bills_bill_details_id_fk FOREIGN KEY (bill_detail_id) REFERENCES public.bill_details(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: bills bills_users_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT bills_users_id_fk FOREIGN KEY (user_id) REFERENCES public.users(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: health_history health_history_users_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.health_history
    ADD CONSTRAINT health_history_users_id_fk FOREIGN KEY (user_id) REFERENCES public.users(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: health_history health_history_users_id_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.health_history
    ADD CONSTRAINT health_history_users_id_fk_2 FOREIGN KEY (doctor_id) REFERENCES public.users(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: lab_reports lab_reports_health_history_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lab_reports
    ADD CONSTRAINT lab_reports_health_history_id_fk FOREIGN KEY (health_id) REFERENCES public.health_history(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: lab_reports lab_reports_users_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lab_reports
    ADD CONSTRAINT lab_reports_users_id_fk FOREIGN KEY (doctor_id) REFERENCES public.users(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: permissions permissions_roles_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permissions
    ADD CONSTRAINT permissions_roles_id_fk FOREIGN KEY (role_id) REFERENCES public.roles(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: users users_addresses_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_addresses_id_fk FOREIGN KEY (address) REFERENCES public.addresses(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: users users_roles_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_roles_id_fk FOREIGN KEY (role_id) REFERENCES public.roles(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: bills bills_bill_details_id_fk; Type: FK CONSTRAINT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".bills
    ADD CONSTRAINT bills_bill_details_id_fk FOREIGN KEY (bill_detail_id) REFERENCES "variant1_Ushurbakiyev".bill_details(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: bills bills_users_id_fk; Type: FK CONSTRAINT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".bills
    ADD CONSTRAINT bills_users_id_fk FOREIGN KEY (user_id) REFERENCES "variant1_Ushurbakiyev".users(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: health_history health_history_users_id_fk; Type: FK CONSTRAINT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".health_history
    ADD CONSTRAINT health_history_users_id_fk FOREIGN KEY (user_id) REFERENCES "variant1_Ushurbakiyev".users(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: health_history health_history_users_id_fk_2; Type: FK CONSTRAINT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".health_history
    ADD CONSTRAINT health_history_users_id_fk_2 FOREIGN KEY (doctor_id) REFERENCES "variant1_Ushurbakiyev".users(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: lab_reports lab_reports_health_history_id_fk; Type: FK CONSTRAINT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".lab_reports
    ADD CONSTRAINT lab_reports_health_history_id_fk FOREIGN KEY (health_id) REFERENCES "variant1_Ushurbakiyev".health_history(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: lab_reports lab_reports_users_id_fk; Type: FK CONSTRAINT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".lab_reports
    ADD CONSTRAINT lab_reports_users_id_fk FOREIGN KEY (doctor_id) REFERENCES "variant1_Ushurbakiyev".users(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: permissions permissions_roles_id_fk; Type: FK CONSTRAINT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".permissions
    ADD CONSTRAINT permissions_roles_id_fk FOREIGN KEY (role_id) REFERENCES "variant1_Ushurbakiyev".roles(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: users users_roles_id_fk; Type: FK CONSTRAINT; Schema: variant1_Ushurbakiyev; Owner: postgres
--

ALTER TABLE ONLY "variant1_Ushurbakiyev".users
    ADD CONSTRAINT users_roles_id_fk FOREIGN KEY (role_id) REFERENCES "variant1_Ushurbakiyev".roles(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

