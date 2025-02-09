public class GenericStack <T extends Comparable>{
    private T [] values;
    private int top;
    public GenericStack(Class<T> dataType, int size){
        this.values= (T[])java.lang.reflect.Array.newInstance(dataType, size);
        this.top=-1;
    }
    public void push(T val){
        if(!isFull()){
            this.top++;
            this.values[this.top]=val;
        }else{
            System.out.println("stack dolu");
        }

    }
    public T pop() throws Exception {
        if(!isEmpty()){
            this.top--;
            return this.values[this.top+1];
        }else{
            throw  new Exception("stack bos");
//            System.out.println("stack boş");
//            return -1;//güzel bir çözüm değil
        }

    }
    public boolean isEmpty(){
        return this.top==-1;
//        if(this.top==-1)
//            return true;
//        else
//            return false;
    }
    public boolean isFull(){
        return this.top==this.values.length-1;
    }
    public void display(){
//        for (int i = this.top; i >-1 ; i--) {
//            System.out.println(this.values[i]);
//        }
        int temp=this.top;
        while(temp!=-1){
            System.out.print(this.values[temp]);
            temp--;
        }

    }
    public boolean search (T val){
        for (int i = 0; i <=this.top ; i++) {
            if (val.compareTo(this.values[i])==0)
                return true;
        }
        return false;
    }

    public void clear(){
        this.top=-1;
    }
    public int size(){return this.values.length;}
}

