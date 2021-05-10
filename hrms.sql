BEGIN;


CREATE TABLE public.candidates
(
    user_id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    identity_number character varying(11) NOT NULL UNIQUE CHECK(length(identity_number)>=11 and length(identity_number)<=11),
    year_of_birth date NOT NULL,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (user_id)
);

COMMENT ON TABLE public.candidates
    IS 'İş Arayanlar';

CREATE TABLE public.users
(
    id integer NOT NULL generated always as identity (start with 1 increment by 1),
    email character varying(50) NOT NULL UNIQUE,
    password character varying(20) NOT NULL,
    confirm_password character varying(20) NOT NULL CHECK(password=confirm_password),
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (id)
);

COMMENT ON TABLE public.users
    IS 'Kullanıcılar';

CREATE TABLE public.employers
(
    user_id integer NOT NULL,
    company_name character varying(100) NOT NULL,
    website character varying(250) NOT NULL,
    phone character varying(11) NOT NULL,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (user_id)
);

COMMENT ON TABLE public.employers
    IS 'İş Verenler';

CREATE TABLE public.verifications
(
    user_id integer NOT NULL,
    confirm boolean NOT NULL DEFAULT false,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.system_employees
(
    user_id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (user_id)
);

COMMENT ON TABLE public.system_employees
    IS 'Sistem Personeli';

CREATE TABLE public.employers_verifications
(
    employer_id integer NOT NULL,
    confirm boolean NOT NULL DEFAULT false,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (employer_id)
);

CREATE TABLE public.job_positions
(
    system_employees_id integer NOT NULL,
    name character varying(50) NOT NULL UNIQUE,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (system_employees_id)
);

COMMENT ON TABLE public.job_positions
    IS 'İş Pozisyonu';

ALTER TABLE public.candidates
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.system_employees
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.verifications
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employers
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.job_positions
    ADD FOREIGN KEY (system_employees_id)
    REFERENCES public.system_employees (user_id)
    NOT VALID;


ALTER TABLE public.employers_verifications
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (user_id)
    NOT VALID;

END;