import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner nao = new Scanner(System.in);
        
        List<List<String>> list = new LinkedList<>();
        List<List<String>> list2 = new LinkedList<>();
        int r=-1, cambio=0;

        while(nao.hasNextLine()){
            String line = nao.nextLine();
            String[] numbersLine = line.split(" ");

            if (line.length() == 0) {
                cambio=1;
                r=-1;
            }else{
                r++;
                if (cambio==0){
                    list.add(new LinkedList<>());
    
                    for (int i = r; i < r+1; i++) {
                        for (int j = 0; j < numbersLine.length; j++) {
                            list.get(i).add(numbersLine[j]);
                        }
                    }    
                }else{
                    list2.add(new LinkedList<>());
    
                    for (int i = r; i < r+1; i++) {
                        for (int j = 0; j < numbersLine.length; j++) {
                            list2.get(i).add(numbersLine[j]);
                        }
                    }
                }
            }
        }

        int mitadR = list.size()/2;
        int mitadC = list.get(0).size()/2;

        Matrix m = new Matrix(list.size(), list.get(0).size());
        Matrix m2 = m;
        Matrix m3 = m;
        Matrix m4 = m;
        Matrix m5 = m; 
        

        m.createSublist();
        new Suma(m, list, list2, mitadR, mitadC);
        new Suma(m2, list, list2, mitadR, mitadC + 1);
        new Suma(m3, list, list2, mitadR + 1, mitadC);
        new Suma(m4, list, list2, mitadR + 1, mitadC + 1);

        //System.out.println(m4.getList());

        try {
            //m.join();
            m2.join();
            m3.join();
            m4.join();
            System.out.println(m5.getList());
            //m5.join();
         
            // for (int i = 0; i < m5.getList().size(); i++) {
            //     for (int j = 0; j < m5.getList().get(i).size(); j++) {
            //         System.out.print(m5.getList().get(i).get(j) + " ");
            //     }    
            //     System.out.println();
            // }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // List<List<String>> list3 = new LinkedList<>();
        // list3 = m.getList();
        // String numero = "";
        // //System.out.println(list3);
        // for (int i = 0; i < list3.size(); i++) {
        //     for (int k = 0; k < list3.get(i).size(); k++) {
        //         numero = list3.get(i).get(k);
        //         System.out.println(numero);
        //     }
        // }



        System.out.println(m.getList());

        // for (int i = 0; i < m.getList().size(); i++) {
        //     for (int j = 0; j < m.getList().get(i).size(); j++) {
        //         System.out.print(m.getList().get(i).get(j) + " ");
        //     }    
        //     System.out.println();
        // }

        // for (int i = 0; i < list3.size(); i++) {
        //     for (int j = 0; j < list3.get(i).size(); j++) {
        //         System.out.print(list3.get(i).get(j) + " ");
        //     }
        //     System.out.println();
        // }

        nao.close();
    }
}

class Matrix extends Thread{
    int renglones;
    int columnas;
    int a=0, b=0, c=0, d=0;
    List<List<String>> listMatrix = new LinkedList<>();
    
    public Matrix(){}

    public Matrix(int renglones, int columnas){
        this.renglones = renglones;
        this.columnas = columnas;
    }

    public void createSublist(){
        for (int i = 0; i < renglones; i++) {
            listMatrix.add(new LinkedList<>());
        }
        
        for (int i = 0; i < renglones; i++) {
            for (int j = 0; j < columnas; j++) {
                listMatrix.get(i).add("0");
            }
        }
    }

    void agregandoMatrix(List<List<String>> list, List<List<String>> list2, int r, int c){
        if (r == renglones/2 && c == columnas/2){
            for (int i = 0; i <= r; i++) {
                for (int j = 0; j <= c; j++) {
                    listMatrix.get(i).set(j, Integer.toString(Integer.parseInt(list.get(i).get(j)) + Integer.parseInt(list2.get(i).get(j))));

                    //Integer.parseInt(list.get(i).get(j)) + Integer.parseInt(list2.get(i).get(j))
                }
            }
            a=1;
            //System.out.println("1: " + listMatrix);
        }else if(r == renglones/2 && c > columnas/2){
            for (int i = 0; i <= r; i++) {
                for (int j = c; j < columnas; j++) {
                    listMatrix.get(i).set(j, Integer.toString(Integer.parseInt(list.get(i).get(j)) + Integer.parseInt(list2.get(i).get(j))));
                }
            }
            b=1;
            //System.out.println("2: " + listMatrix);
        }else if(r > renglones/2 && c == columnas/2){
            for (int i = r; i < renglones; i++) {
                for (int j = 0; j <= c; j++) {
                    listMatrix.get(i).set(j, Integer.toString(Integer.parseInt(list.get(i).get(j)) + Integer.parseInt(list2.get(i).get(j))));
                }
            }
            c=1;
            //System.out.println("3: " + listMatrix);
        }else if(r > renglones/2 && c > columnas/2){
            for (int i = r; i < renglones; i++) {
                for (int j = c; j < columnas; j++) {
                    listMatrix.get(i).set(j, Integer.toString(Integer.parseInt(list.get(i).get(j)) + Integer.parseInt(list2.get(i).get(j))));
                }
            }
            d=1;
            //System.out.println("4: " + listMatrix);
        }

        // if (a==1 && b==1 && c==1 && d==1){
        //     System.out.println("5: " + listMatrix);
        // }
    }

    List<List<String>> getList(){
        return listMatrix;
    }
}

class Suma implements Runnable{
    Matrix m;
    int renglones;
    int columnas;
    List<List<String>> list;
    List<List<String>> list2;

    Suma(Matrix m, List<List<String>> list, List<List<String>> list2, int renglones, int columnas){
        this.m = m;
        this.list = list;
        this.list2 = list2;
        this.renglones = renglones;
        this.columnas = columnas;
        new Thread(this).start();
    }

    public void run(){
        m.agregandoMatrix(list, list2, renglones, columnas);
    }   
}