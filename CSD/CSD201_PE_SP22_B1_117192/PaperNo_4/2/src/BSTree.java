/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xTower, int xSound, int xType) {
        if (xTower.charAt(0) == 'A') {

        } else {

            if (search(new Bell(xTower, xSound, xType)) == null) {
                Node newnode = new Node(new Bell(xTower, xSound, xType));
                Node q = root;
                Node parent = null;//trailing
                //traverse down
                while (q != null) {
                    parent = q;
                    if (q.info.type > xType) {
                        q = q.left;
                    } else {
                        q = q.right;
                    }
                }
                if (parent == null) {
                    root = newnode;
                } else if (xType < parent.info.type) {
                    parent.left = newnode;
                } else {
                    parent.right = newnode;
                }
            }
        }

    }

    Node search(Bell x) {
        Node q = root;
        while (q != null) {
            if (x.type > q.info.type) {
                q = q.right;
            } else if (x.type < q.info.type) {
                q = q.left;
            } else {
                return q;
            }
        }
        return null;
    }
//Do not edit this function. Your task is to complete insert function above only.

    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void postOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder2(p.left, f);
        postOrder2(p.right, f);
        fvisit2(p, f);
    }

    void fvisit2(Node p, RandomAccessFile f) throws Exception {
        if (p != null && p.info.sound > 4) {
            f.writeBytes(p.info + " ");
        }
    }
//=============================================================

    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        postOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
        this.postOrder2(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void inOrder3(Node p, ArrayList<Node> list) throws Exception {
        if (p == null) {
            return;
        }

        inOrder3(p.left, list);
        list.add(p);
        inOrder3(p.right, list);
    }

    int count(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
//=============================================================

    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
        ArrayList<Node> list = new ArrayList<>();
        this.inOrder3(root, list);
        int count = this.count(list.get(3));
        list.get(3).info.sound = count;
//        a.info = new Bell(a.info.tower, this.count(a), a.info.type);
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
        ArrayList<Node> list = new ArrayList<>();
        this.inOrder3(root, list);
        Node p = list.get(3);
        if (p.left != null) {
            Node x = p.left;
            Node y = x.right;
            //rotate
            x.right = p;
            p.left = y;
            if (this.parent(p.info.sound).right == p) {
                this.parent(p.info.sound).right = x;
            } else {
                this.parent(p.info.sound).left = x;
            }

        }
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    Node parent(int sound) {
        Node p = root;
        if (root == null) {
            return null;
        }
        if (root.info.sound == sound) {
            return root;
        }
        while (p != null) {
            if (p.left.info.sound == sound || p.right.info.sound == sound) {
                return p;
            } else if (p.info.sound < sound) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return null;
    }

}
