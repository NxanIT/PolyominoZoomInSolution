<img width="361" height="250" alt="grafik" src="https://github.com/user-attachments/assets/60514045-5fcf-4860-b625-275cd4750530" />
<img width="240" height="250" alt="grafik" src="https://github.com/user-attachments/assets/17bc947c-6b62-49ec-93f3-ca1d64e43d45" />
<img width="228" height="250" alt="grafik" src="https://github.com/user-attachments/assets/8fc36a21-4740-417d-a577-d5dcacdc6f3f" />

Given the solutions of a polyomino-puzzle one could ask themselves, how related the solutions are to each other.
### Example: 
Given one solution there might be two polyominos that can be taken out and put back in a different way, creating a new solution.
Like in this example with the only difference being the position of the grey and blue polyomino.

<img width="400" height="400" alt="solution1" src="https://github.com/user-attachments/assets/9052393f-7196-4793-9a6e-14f522ffd6b0" />
<img width="400" height="400" alt="solution2" src="https://github.com/user-attachments/assets/fa16dd1a-a161-454c-81a8-c134e1b0c7db" />

We then say the above solutions have a distance of 2, or are leq-2-connected.

However due to the many solutions such a puzzle may have, a graph of all solutions may not give as much insight into this question.

This project therefore eneralizes the above idea to create graphs with the following features: Given two numbers 1 <= n < m <= #polyominos
 - nodes are the equivalence classes of solutions modulo the composit closure of leq-n-connectedness;
   One equivalence class contains all the solutions, for which there
   exists a finite number of leq-n-changes to get from one solution to the other.
 - edges are drawn between two equivalence classes of solutions, if there are two representatives of the equivalence classes, which are leq-m-connected.

This narrows down the number of nodes in the example puzzle given from 32288 to just 971, if we take n=4 and m=5.
The biggest connected component of this result is the uppermost - left picture. The node highlighted in green contains about 90% of all possible solutions.

And we can repeat this step. Given the subgraph of only the green highlighted equivalence class. We repeat this with n=3 and m=4 and obtain the middle picture.
Repeated again with n=2 and m=3, we get the third picture above.

This Project let's you 'zoom-in' on a specific solution using this procedure. It creates the following files:

- In directory
  - `*_solution_ids.txt` - a listing of all solution-ids occuring in the graph (no equivalence classes)
  - `*_nodes.csv` - a listing of all nodes occuring (no equivalence classes)
- Out directory
  - `*_size[X]_leqm-n.csv_EQ.csv` - nodes (equivalence classes)
  - `*_size[X]_leqm-n.csv_ET.csv` - edge table containing all edges
  - `*_size[X]_leqm-n.csv_NT.csv` - nodes weight table
    
The files generated in the output directory are easily imported 
into a graph-viewing program, like [Gephi](https://gephi.org/), which I used to get the above graphs.

>[!Note]
> The file DisjointUnion.scala is not yet uploaded.
>It uses a basic implementation of the disjoint union algorithm and will be replaced with an implementation
>using cats in the future.
