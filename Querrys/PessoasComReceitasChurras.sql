CREATE OR REPLACE VIEW public.vw_pessoas_com_receitas_churras
AS SELECT p.nome AS nome_pessoa,
    r.nomereceita
   FROM pessoa p
     JOIN receitas r ON p.id = r.pessoa_id
  WHERE r.categoria::text = 'CHURRAS'::text;