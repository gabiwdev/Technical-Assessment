# Technical Assessment

## Desafio técnico ##
Código que analisa um código de HTML, detecta o texto na camada mais profunda do HTML e o retorna. Caso haja 2 textos, retornará o primeiro.
Além disso detecta má formações no HTML.

## Funcionalidades

- Analisa o código HTML linha por linha.
- Encontra o primeiro texto mais profundo no nivel de aninhamento das tags e o retorna.
- Detecta má formação de HTML incluindo:
  - Tags de fechamento sem abertura.
  - Tags fechadas fora de ordem.
 
## Decisões de Implementação

- Foi implementado um sistema da detecção de má formação com stack que valida a abertura e o fechamento.
- O numero da profundidade é atualizado apenas após a validação estrutural.
- Em caso de múltiplos textos no mesmo nível, o primeiro é retornado conforme solicitado no desafio.
 
## Assunções 

- O código leva em conta que uma linha pode ser apenas:
  - Uma tag de abertura;
  - Uma tag de fechamento;
  - Um texto.
- O HTML não contém comentarios ou instruções especiais como <!DOCTYPE>
