namespace Queue
{
    public class Queue<T>()
    {
        private T[] q= new T[1];
        private int f=0;
        private int b=0;

        public void enqueue(T item)
        {
            if (b == q.Length & f == 0 & b!=f)
            {
                resize(b * 2);
            }
            else if (b == q.Length & f != 0 & b!=f)
            {
                move();
            }
            
            q[b] = item;
            b++;

            Console.WriteLine(q.Length) ;

        }
        public T dequeue()
        {
            if (f != b) 
            {
                f++;
                Console.WriteLine(q.Length);
                return q[f-1];
            }
            else
            {
                throw new Exception("the queue is empty");
            }
            
        }

        public void move()
        {
            int counter = 0; 
            for (int i = f; i <b ; i++)
            {
                q[counter] = q[i];
                counter++;
            }
            b = b - f;
            f = 0;
        }
        public bool isEmpty()
        {
            return  f== b;
        }
        private void resize(int newsize)
        {
            var copy = new T[newsize];
            int counter = 0;
            for (int i = 0;i< b - f ; i++)
            {
                copy[counter] = q[i];
                counter++;
            }
            q = copy;
        }

    }

    public class Program
    {
        public static void Main(String[] args)
        {
            var queue = new Queue<string>();
            queue.enqueue("hello");
            queue.enqueue("new");
            queue.enqueue("world!");

            for (int i = 0; i < 3; i++)
            {
                Console.WriteLine(queue.dequeue());
            }
            Console.ReadLine();
        }
    }
}