from collections import deque

def inputEdges(edges):
    no_of_edges = int(input("No. of edges : "))

    for _ in range(no_of_edges):
        edges.append(list(map(int, input().split())))

def createGraph(graph, edges, n):

    for i in range(1, n+1):
        graph[i] = list()

    for k, v in edges:
        graph[k].append(v)

def printBFS(graph, n):
    
    visited = [False] * (n+1)
    queue = deque()

    visited[1] = True
    queue.append(1)

    result = list()

    while(len(queue) > 0):

        currNode = queue.popleft()
        result.append(currNode)
        
        for adj in graph[currNode]:

            if(visited[adj] == False):
                visited[adj] = True
                queue.append(adj)
                
    return result


    
if __name__ == "__main__":

    n = int(input("No. of nodes : "))
    edges = list()
    inputEdges(edges)
    print(edges)
    # example : len = 7, edges = [[1,2], [1,3], [2, 4], [2, 5], [3, 8], [5, 6], [6, 7]]

    graph = dict()

    createGraph(graph, edges, n)
    print(graph)

    result = printBFS(graph, n)

    print()
    print(result)

