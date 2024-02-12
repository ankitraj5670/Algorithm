import java.util.*;

class Operation {
    private int[] id;
    private int[] sz;

    public Operation(int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 0;
        }
    }

    private int root (int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        if (sz[pid] < sz[qid]) {
            id[pid] = qid;
            sz[pid] += sz[qid];
        } else {
            id[qid] = pid;
            sz[qid] += sz[pid];
        }
    }

    public void display() {
    	for (int i = 0 ; i < id.length; i++) {
    		System.out.println("id[" + i + "] = " + id[i]);
    	}
    }
}

public class QuickUnionWeightedPathCompression {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of nodes = ");
        int n = input.nextInt();
        Operation uf = new Operation(n);
        input.nextLine();
        while (true) {
            System.out.print("union(p,q): ");
            int p = input.nextInt();
            int q = input.nextInt();
            input.nextLine();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }
            System.out.println();
            System.out.print("Enter q to quit and c to continue... ");
            String choice = input.nextLine();
            System.out.println();
            if (choice.equals("q")) {
                break;
            }
        }
        System.out.println();
        uf.display();
    }
}