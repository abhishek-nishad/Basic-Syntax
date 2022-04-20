from collections import deque

def createGraph(graph, edges, n):

    for i in range(1, n+1):
        graph[i] = list()

    for k, v in edges:
        graph[k].append(v)

def printBFS(graph, n):
    
    visited = [False] * (n+1)
    queue = list()

    visited[1] = True
    queue.append(1)

    result = list()

    while(len(queue) > 0):
        currNode = queue.pop(0)
        result.append(currNode)
        
        for adj in graph[currNode]:
            if(visited[adj] == False):
                visited[adj] = True
                queue.append(adj)
                
    return result


    
if __name__ == "__main__":
    n = 8
    edges = [[1,2], [1,3], [2, 4], [2, 5], [3, 8], [5, 6], [6, 7]]
    graph = dict()

    createGraph(graph, edges, n)

    result = printBFS(graph, n)

    print(result)

