CREATE OR REPLACE VIEW public.vw_receitas_com_maior_custo
AS SELECT r.id,
    r.nomereceita,
    r.custoproducao,
    p.nome AS nomepessoa
   FROM receitas r
     JOIN pessoa p ON p.id = r.pessoa_id
  ORDER BY r.custoproducao DESC;