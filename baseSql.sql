PGDMP         9                |            PH2    15.2    15.2 K    X           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            Y           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            Z           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            [           1262    123049    PH2    DATABASE     y   CREATE DATABASE "PH2" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "PH2";
                postgres    false            �            1259    123109    active_substance    TABLE     �   CREATE TABLE public.active_substance (
    id bigint NOT NULL,
    name character varying(30) NOT NULL,
    description text NOT NULL
);
 $   DROP TABLE public.active_substance;
       public         heap    postgres    false            �            1259    123108    active_substance_id_seq    SEQUENCE     �   CREATE SEQUENCE public.active_substance_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.active_substance_id_seq;
       public          postgres    false    215            \           0    0    active_substance_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.active_substance_id_seq OWNED BY public.active_substance.id;
          public          postgres    false    214            �            1259    123118    documents_employer    TABLE     �   CREATE TABLE public.documents_employer (
    id integer NOT NULL,
    passport_id character varying(30) NOT NULL,
    phone character varying(12) NOT NULL
);
 &   DROP TABLE public.documents_employer;
       public         heap    postgres    false            �            1259    123117    documents_employer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.documents_employer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.documents_employer_id_seq;
       public          postgres    false    217            ]           0    0    documents_employer_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.documents_employer_id_seq OWNED BY public.documents_employer.id;
          public          postgres    false    216            �            1259    123125 	   employees    TABLE     �   CREATE TABLE public.employees (
    id integer NOT NULL,
    first_name character varying NOT NULL,
    last_name character varying NOT NULL,
    middle_name character varying NOT NULL,
    dociments smallint NOT NULL
);
    DROP TABLE public.employees;
       public         heap    postgres    false            �            1259    123124    employees_id_seq    SEQUENCE     �   CREATE SEQUENCE public.employees_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.employees_id_seq;
       public          postgres    false    219            ^           0    0    employees_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.employees_id_seq OWNED BY public.employees.id;
          public          postgres    false    218            �            1259    123134 
   group_drug    TABLE     �   CREATE TABLE public.group_drug (
    id bigint NOT NULL,
    name character varying(30) NOT NULL,
    description text NOT NULL
);
    DROP TABLE public.group_drug;
       public         heap    postgres    false            �            1259    123133    group_drug_id_seq    SEQUENCE     z   CREATE SEQUENCE public.group_drug_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.group_drug_id_seq;
       public          postgres    false    221            _           0    0    group_drug_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.group_drug_id_seq OWNED BY public.group_drug.id;
          public          postgres    false    220            �            1259    123143    manufacturer    TABLE     �   CREATE TABLE public.manufacturer (
    id bigint NOT NULL,
    name character varying(30) NOT NULL,
    description text NOT NULL,
    country character varying(30)
);
     DROP TABLE public.manufacturer;
       public         heap    postgres    false            �            1259    123142    manufacturer_id_seq    SEQUENCE     |   CREATE SEQUENCE public.manufacturer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.manufacturer_id_seq;
       public          postgres    false    223            `           0    0    manufacturer_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.manufacturer_id_seq OWNED BY public.manufacturer.id;
          public          postgres    false    222            �            1259    123151 	   medicines    TABLE     �   CREATE TABLE public.medicines (
    id bigint NOT NULL,
    active_substance integer NOT NULL,
    group_drug smallint NOT NULL
);
    DROP TABLE public.medicines;
       public         heap    postgres    false            �            1259    123157    product    TABLE     �   CREATE TABLE public.product (
    id bigint NOT NULL,
    name character varying(40) NOT NULL,
    price numeric(8,2) NOT NULL,
    manufacturer integer NOT NULL
);
    DROP TABLE public.product;
       public         heap    postgres    false            �            1259    123156    product_id_seq    SEQUENCE     w   CREATE SEQUENCE public.product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.product_id_seq;
       public          postgres    false    226            a           0    0    product_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.product_id_seq OWNED BY public.product.id;
          public          postgres    false    225            �            1259    123164    sale    TABLE     �   CREATE TABLE public.sale (
    id bigint NOT NULL,
    date timestamp without time zone NOT NULL,
    amount numeric(8,2) NOT NULL,
    employee smallint NOT NULL
);
    DROP TABLE public.sale;
       public         heap    postgres    false            �            1259    123163    sale_id_seq    SEQUENCE     t   CREATE SEQUENCE public.sale_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.sale_id_seq;
       public          postgres    false    228            b           0    0    sale_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.sale_id_seq OWNED BY public.sale.id;
          public          postgres    false    227            �            1259    123170    sale_warehouse    TABLE     �   CREATE TABLE public.sale_warehouse (
    sale_id bigint NOT NULL,
    warehouse_id bigint NOT NULL,
    quantity integer DEFAULT 1 NOT NULL
);
 "   DROP TABLE public.sale_warehouse;
       public         heap    postgres    false            �            1259    123177 	   warehouse    TABLE     �   CREATE TABLE public.warehouse (
    id bigint NOT NULL,
    batch_number bigint NOT NULL,
    production_date date NOT NULL,
    expiration_date date NOT NULL,
    date_receipt date NOT NULL,
    product bigint NOT NULL,
    quantity integer NOT NULL
);
    DROP TABLE public.warehouse;
       public         heap    postgres    false            �            1259    123176    warehouse_id_seq    SEQUENCE     y   CREATE SEQUENCE public.warehouse_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.warehouse_id_seq;
       public          postgres    false    231            c           0    0    warehouse_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.warehouse_id_seq OWNED BY public.warehouse.id;
          public          postgres    false    230            �           2604    123112    active_substance id    DEFAULT     z   ALTER TABLE ONLY public.active_substance ALTER COLUMN id SET DEFAULT nextval('public.active_substance_id_seq'::regclass);
 B   ALTER TABLE public.active_substance ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    214    215            �           2604    123121    documents_employer id    DEFAULT     ~   ALTER TABLE ONLY public.documents_employer ALTER COLUMN id SET DEFAULT nextval('public.documents_employer_id_seq'::regclass);
 D   ALTER TABLE public.documents_employer ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217            �           2604    123128    employees id    DEFAULT     l   ALTER TABLE ONLY public.employees ALTER COLUMN id SET DEFAULT nextval('public.employees_id_seq'::regclass);
 ;   ALTER TABLE public.employees ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    219    219            �           2604    123137    group_drug id    DEFAULT     n   ALTER TABLE ONLY public.group_drug ALTER COLUMN id SET DEFAULT nextval('public.group_drug_id_seq'::regclass);
 <   ALTER TABLE public.group_drug ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    221    221            �           2604    123146    manufacturer id    DEFAULT     r   ALTER TABLE ONLY public.manufacturer ALTER COLUMN id SET DEFAULT nextval('public.manufacturer_id_seq'::regclass);
 >   ALTER TABLE public.manufacturer ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    223    223            �           2604    123160 
   product id    DEFAULT     h   ALTER TABLE ONLY public.product ALTER COLUMN id SET DEFAULT nextval('public.product_id_seq'::regclass);
 9   ALTER TABLE public.product ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    225    226    226            �           2604    123167    sale id    DEFAULT     b   ALTER TABLE ONLY public.sale ALTER COLUMN id SET DEFAULT nextval('public.sale_id_seq'::regclass);
 6   ALTER TABLE public.sale ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    228    227    228            �           2604    123180    warehouse id    DEFAULT     l   ALTER TABLE ONLY public.warehouse ALTER COLUMN id SET DEFAULT nextval('public.warehouse_id_seq'::regclass);
 ;   ALTER TABLE public.warehouse ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    230    231    231            E          0    123109    active_substance 
   TABLE DATA           A   COPY public.active_substance (id, name, description) FROM stdin;
    public          postgres    false    215   �U       G          0    123118    documents_employer 
   TABLE DATA           D   COPY public.documents_employer (id, passport_id, phone) FROM stdin;
    public          postgres    false    217   ,V       I          0    123125 	   employees 
   TABLE DATA           V   COPY public.employees (id, first_name, last_name, middle_name, dociments) FROM stdin;
    public          postgres    false    219   IV       K          0    123134 
   group_drug 
   TABLE DATA           ;   COPY public.group_drug (id, name, description) FROM stdin;
    public          postgres    false    221   fV       M          0    123143    manufacturer 
   TABLE DATA           F   COPY public.manufacturer (id, name, description, country) FROM stdin;
    public          postgres    false    223   �V       N          0    123151 	   medicines 
   TABLE DATA           E   COPY public.medicines (id, active_substance, group_drug) FROM stdin;
    public          postgres    false    224   �W       P          0    123157    product 
   TABLE DATA           @   COPY public.product (id, name, price, manufacturer) FROM stdin;
    public          postgres    false    226   �W       R          0    123164    sale 
   TABLE DATA           :   COPY public.sale (id, date, amount, employee) FROM stdin;
    public          postgres    false    228   X       S          0    123170    sale_warehouse 
   TABLE DATA           I   COPY public.sale_warehouse (sale_id, warehouse_id, quantity) FROM stdin;
    public          postgres    false    229    X       U          0    123177 	   warehouse 
   TABLE DATA           x   COPY public.warehouse (id, batch_number, production_date, expiration_date, date_receipt, product, quantity) FROM stdin;
    public          postgres    false    231   =X       d           0    0    active_substance_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.active_substance_id_seq', 1, true);
          public          postgres    false    214            e           0    0    documents_employer_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.documents_employer_id_seq', 1, false);
          public          postgres    false    216            f           0    0    employees_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.employees_id_seq', 1, false);
          public          postgres    false    218            g           0    0    group_drug_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.group_drug_id_seq', 1, true);
          public          postgres    false    220            h           0    0    manufacturer_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.manufacturer_id_seq', 4, true);
          public          postgres    false    222            i           0    0    product_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.product_id_seq', 4, true);
          public          postgres    false    225            j           0    0    sale_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.sale_id_seq', 1, false);
          public          postgres    false    227            k           0    0    warehouse_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.warehouse_id_seq', 1, false);
          public          postgres    false    230            �           2606    123116 &   active_substance active_substance_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.active_substance
    ADD CONSTRAINT active_substance_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.active_substance DROP CONSTRAINT active_substance_pkey;
       public            postgres    false    215            �           2606    123123 *   documents_employer documents_employer_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.documents_employer
    ADD CONSTRAINT documents_employer_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.documents_employer DROP CONSTRAINT documents_employer_pkey;
       public            postgres    false    217            �           2606    123132    employees employees_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.employees DROP CONSTRAINT employees_pkey;
       public            postgres    false    219            �           2606    123141    group_drug group_drug_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.group_drug
    ADD CONSTRAINT group_drug_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.group_drug DROP CONSTRAINT group_drug_pkey;
       public            postgres    false    221            �           2606    123150    manufacturer manufacturer_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.manufacturer
    ADD CONSTRAINT manufacturer_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.manufacturer DROP CONSTRAINT manufacturer_pkey;
       public            postgres    false    223            �           2606    123155    medicines medicines_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.medicines
    ADD CONSTRAINT medicines_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.medicines DROP CONSTRAINT medicines_pkey;
       public            postgres    false    224            �           2606    123162    product product_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.product DROP CONSTRAINT product_pkey;
       public            postgres    false    226            �           2606    123169    sale sale_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.sale
    ADD CONSTRAINT sale_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.sale DROP CONSTRAINT sale_pkey;
       public            postgres    false    228            �           2606    123175 "   sale_warehouse sale_warehouse_pkey 
   CONSTRAINT     s   ALTER TABLE ONLY public.sale_warehouse
    ADD CONSTRAINT sale_warehouse_pkey PRIMARY KEY (sale_id, warehouse_id);
 L   ALTER TABLE ONLY public.sale_warehouse DROP CONSTRAINT sale_warehouse_pkey;
       public            postgres    false    229    229            �           2606    123182    warehouse warehouse_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.warehouse
    ADD CONSTRAINT warehouse_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.warehouse DROP CONSTRAINT warehouse_pkey;
       public            postgres    false    231            �           2606    123188    medicines active_substance    FK CONSTRAINT     �   ALTER TABLE ONLY public.medicines
    ADD CONSTRAINT active_substance FOREIGN KEY (active_substance) REFERENCES public.active_substance(id) NOT VALID;
 D   ALTER TABLE ONLY public.medicines DROP CONSTRAINT active_substance;
       public          postgres    false    3226    224    215            �           2606    123183 "   employees employees_dociments_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_dociments_fkey FOREIGN KEY (dociments) REFERENCES public.documents_employer(id) NOT VALID;
 L   ALTER TABLE ONLY public.employees DROP CONSTRAINT employees_dociments_fkey;
       public          postgres    false    219    217    3228            �           2606    123208    sale employer    FK CONSTRAINT     {   ALTER TABLE ONLY public.sale
    ADD CONSTRAINT employer FOREIGN KEY (employee) REFERENCES public.employees(id) NOT VALID;
 7   ALTER TABLE ONLY public.sale DROP CONSTRAINT employer;
       public          postgres    false    219    228    3230            �           2606    123193 #   medicines medicines_group_drug_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.medicines
    ADD CONSTRAINT medicines_group_drug_fkey FOREIGN KEY (group_drug) REFERENCES public.group_drug(id) NOT VALID;
 M   ALTER TABLE ONLY public.medicines DROP CONSTRAINT medicines_group_drug_fkey;
       public          postgres    false    221    3232    224            �           2606    123198    medicines medicines_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.medicines
    ADD CONSTRAINT medicines_id_fkey FOREIGN KEY (id) REFERENCES public.product(id) NOT VALID;
 E   ALTER TABLE ONLY public.medicines DROP CONSTRAINT medicines_id_fkey;
       public          postgres    false    224    3238    226            �           2606    123203 !   product product_manufacturer_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_manufacturer_fkey FOREIGN KEY (manufacturer) REFERENCES public.manufacturer(id) NOT VALID;
 K   ALTER TABLE ONLY public.product DROP CONSTRAINT product_manufacturer_fkey;
       public          postgres    false    223    3234    226            �           2606    123213 *   sale_warehouse sale_warehouse_sale_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.sale_warehouse
    ADD CONSTRAINT sale_warehouse_sale_id_fkey FOREIGN KEY (sale_id) REFERENCES public.sale(id) NOT VALID;
 T   ALTER TABLE ONLY public.sale_warehouse DROP CONSTRAINT sale_warehouse_sale_id_fkey;
       public          postgres    false    228    3240    229            �           2606    123218 /   sale_warehouse sale_warehouse_warehouse_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.sale_warehouse
    ADD CONSTRAINT sale_warehouse_warehouse_id_fkey FOREIGN KEY (warehouse_id) REFERENCES public.warehouse(id) NOT VALID;
 Y   ALTER TABLE ONLY public.sale_warehouse DROP CONSTRAINT sale_warehouse_warehouse_id_fkey;
       public          postgres    false    231    229    3244            �           2606    123223     warehouse warehouse_product_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.warehouse
    ADD CONSTRAINT warehouse_product_fkey FOREIGN KEY (product) REFERENCES public.product(id) NOT VALID;
 J   ALTER TABLE ONLY public.warehouse DROP CONSTRAINT warehouse_product_fkey;
       public          postgres    false    231    226    3238            E   ?   x�3估�¾�-[.l����^�/컰�b�����@��
6]�
b^l��d������ �"�      G      x������ � �      I      x������ � �      K   J   x�3�Թ��[8�Ԏ�.���v\l���b�]v( ew]lJn���b���
� Հ4m�s��qqq �._      M   �   x�uP��@|{��
"qt���RAB B�JHB����¸#�H�Xo�sx���
t(t&�"��#�k��(	׺�h���9�:�8��0������𝯝�����/�H.�j.���<���Y���pÃ~�d<�cG�Р�+�6+P��9Y�	����/��V{k�м;o��9!҄dבNv5n��iŻc.�˾O��:���      N      x������ � �      P   3   x�3�0�{/6]�V����Ƌ�ہ��[9�8M�b���� �      R      x������ � �      S      x������ � �      U      x������ � �     