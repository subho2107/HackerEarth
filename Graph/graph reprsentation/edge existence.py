#python3
class Vertex:
    def __init__(self, node):
        self.adjacent = {}
        self.id = node
    def addNeighbour(self,neighbour):
        self.adjacent[neighbour] = 0
class Graph:
    def __init__(self):
        self.vertDictionary = {}
        self.noOfEdges = 0
    def addVertex(self, node):
        self.noOfEdges += 1
        newVertex = Vertex(node)
        self.vertDictionary[node] = newVertex
    def addEdge(self, frm, to):
        if frm not in self.vertDictionary:
            self.addVertex(frm)
        if to not in self.vertDictionary:
            self.addVertex(to)
        self.vertDictionary[frm].addNeighbour(self.vertDictionary[to])
        self.vertDictionary[to].addNeighbour(self.vertDictionary[frm])
    def hasNeighbour(self, frm, to):
        if self.getVertex(to) in self.vertDictionary[frm].adjacent:
            return True
        else:
            return False
    def getVertex(self, node):
        if node in self.vertDictionary:
            return self.vertDictionary[node]
        else:
            return None
NandM = list(map(int, input().rstrip().split()))
noOfNodes = NandM[0]
noOfEdges = NandM[1]
G = Graph()
for _ in range(noOfEdges):
    AandB = list(map(int, input().rstrip().split()))
    A = AandB[0]
    B = AandB[1]
    G.addEdge(A, B)
res = 0
AandB = list(map(int, input().rstrip().split()))
A = AandB[0]
B = AandB[1]
if G.hasNeighbour(A, B):
    res = 1

print(res)
