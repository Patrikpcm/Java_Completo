public class Boxing {
    public static void main(String[] args) {
        int x = 20; //crio uma variável tipo int
        Object obj = x; //object é um tipo genérico, todos os tipos são filhos dele. 
                        //Nesse exemplo, obj é um objeto que guarda int X (tipo primitivo)
                        //num espaço de memória do Heap.
                        //Seria como guardar int x numa caixinha (boxing).
        
        int y = (int)obj; //unboxing, salvando o objeto numa variável primitiva int novamente.
        System.out.println(y);
        System.out.println(obj);
    }
}

/**
 *              Wrapper classes
 * - São classes equivalentes aos tipos primitivos
 * - Boxing e unboxing é natural na linguagem
 * - Uso comum: Campos de entidades em sistemas de informação (IMPORTANTE!)
 *      Pois tipos referência(classes) aceitam valor null e usufruem dos recursos OO
 * 
 *Pai de todos os tipos-                                                       Object
                                                            ______________________|______________
                                                           |                |                    |
 *Os 3 são filhos de Object-                             Number      Boolean(boolean)     Character(char)
                                    _______________________|__________________________________________________
                                    |           |               |               |           |                |
 *Filhos de Number-             Byte(byte)  Short(short)    Integer(int)    Long(long)  Float(float)    Double(double)
 */