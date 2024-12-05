CREATE OR REPLACE VIEW public.vw_pessoas_e_receitas
AS SELECT p.id AS pessoa_id,
    p.nome AS nome_pessoa,
    r.id AS receita_id,
    r.nomereceita,
    r.categoria,
    r.custoproducao
   FROM pessoa p
     LEFT JOIN receitas r ON p.id = r.pessoa_id;