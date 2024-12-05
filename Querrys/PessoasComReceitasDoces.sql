CREATE OR REPLACE VIEW public.vw_pessoas_com_receitas_doces
AS SELECT p.nome,
    r.nomereceita
   FROM pessoa p
     JOIN receitas r ON p.id = r.pessoa_id
  WHERE r.categoria::text = 'DOCE'::text;