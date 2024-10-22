from graphviz import Digraph

# Criar o diagrama
db_diagram = Digraph('Banco de Dados', node_attr={'shape': 'record', 'height': '.1'})

# Definir entidades
db_diagram.node('Aluno', '<f0>Aluno|<f1>id: Long|<f2>nome: String|<f3>matricula: String')
db_diagram.node('Materia', '<f0>Materia|<f1>id: Long|<f2>codigoTurma: String|<f3>nome: String|<f4>horario1: String|<f5>horario2: String')
db_diagram.node('Professor', '<f0>Professor|<f1>id: Long|<f2>nome: String')
db_diagram.node('Inscricao', '<f0>Inscricao|<f1>id: Long|<f2>faltas: int|<f3>notaN1: double|<f4>notaN2: double|<f5>status: String')

# Definir relacionamentos
db_diagram.edge('Aluno', 'Inscricao', label='1:N')
db_diagram.edge('Materia', 'Inscricao', label='1:N')
db_diagram.edge('Professor', 'Materia', label='1:N')

# Renderizar o diagrama
db_diagram