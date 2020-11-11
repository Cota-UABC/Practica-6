import java.util.Scanner;

public class zoologico{
    public static void main(String[] args) {
		int num,i,p,edad,a,pos;
		String nombre,nombreA,op;
		boolean f=true,f2,aumentar;
		
	//zoo zz = new zoo();
	datosAnimal datos = new datosAnimal();
	
	Animal [] animalArray = new Animal [6]; //array de objetos
	animalArray[0] = new Elefante();
	animalArray[1] = new Jirafa();
	animalArray[2] = new Leon();
	animalArray[3] = new Tigre();
	animalArray[4] = new Chimpanse();
	animalArray[5] = new Loro();
	
	for(i=0;i<6;i++){//inializa todos los atributos de los objetos
		animalArray[i].inicializarAtributos();
	}
	
	Scanner sc= new Scanner(System.in);
	
		do{
			System.out.print("\n----------------------------------"+//menu
							"\nQue deseas hacer:"+ 
							"\n1.Mostrar animales en el zoologico"+
							"\n2.Agregar animal"+
							"\n3.Eliminar animal" +
							"\n4.Atender animal"+
							"\n5.Salir"+
							"\n\nIngresa numero: ");
			num = sc.nextInt();
							
							switch(num){  //switch case para el menu
							case 1: f2=true;//case para mostrar animales
									do{
									System.out.print("\nDe que tipo de animal deseas ver la lista.");
									num = datos.tipo();//saca la lista de tipos de animales 
									p = animalArray[num].getPosicion();//obtine la posicion del ultimo animaa en la lista
									if(p==0) System.out.print("\nNo se encuentrar animales registrados\n");
									else{
									nombreA = datos.nomTipo(num);//obtiene el String de tipo de animal
									System.out.print("\n\n--"+ nombreA+"--\n");
									for(i=0;i<p;i++){//saca la lista de los animales, con nombre y edad
										pos=i+1;
										System.out.println(""+pos+". "+animalArray[num].getNombre(i)+" | "+animalArray[num].getEdad(i)+" a\u00f1os");
									}			
									}
									
									System.out.print("\nDesea ver otro tipo de animal(S/N):");
									Scanner scan= new Scanner(System.in);//no funciona el scan si no lo coloco aqui
									op = scan.nextLine();
									if(op.equals("n") || op.equals("N")) f2=false;
									}while(f2==true);
								break;
							case 2: f2=true;
									do{//case para agregar animales
									System.out.print("\nDe que tipo de animal deseas agregar.");
									num = datos.tipo();//saca la lista de tipos de animales 
									p = animalArray[num].getPosicion();//obtine la posicion del ultimo animaa en la lista
									animalArray[num].setNombre(datos.nombre(),p);//agrega el nombre del animal
									animalArray[num].setEdad(datos.edad(),p);//agrega la edad del animal
									animalArray[num].cambiarPosicion(true);//aumenta la ultima posicion
									
									System.out.print("\nDesea agregar otro animal(S/N):");
									Scanner scan= new Scanner(System.in);//no funciona el scan si no lo coloco aqui
									op = scan.nextLine();
									if(op.equals("n") || op.equals("N")) f2=false;
									}while(f2==true);
								break;	
							case 3: f2=true;
									do{//case para eliminar un animal
									System.out.print("\nDe que tipo de animal desea eliminar.");
									num = datos.tipo();//saca la lista de tipos de animales 
									p = animalArray[num].getPosicion();//obtine la posicion del ultimo animal en la lista
									if(p==0) System.out.print("\nNo se encuentrar animales registrados\n");
									else{
									nombreA = datos.nomTipo(num);//obtiene el String de tipo de animal
									System.out.print("\n\n--"+ nombreA+"--\n");
									for(i=0;i<p;i++){//saca la lista de los animales, con nombre y edad
										pos=i+1;
										System.out.println(""+pos+". "+animalArray[num].getNombre(i)+" | "+animalArray[num].getEdad(i)+" a\u00f1os");
									}			
									
									System.out.print("\nCual desea eliminar,ingrese el numero de la posicion:");
									a = sc.nextInt()-1;
									if(a<0 || a>p+1) System.out.println("\nPosicion no existente");
									else{
									animalArray[num].setNombre("",a);//borra los datos de la posicion ingresada
									animalArray[num].setEdad(0,a);
									for(i=a;i<p;i++){
										animalArray[num].setNombre(animalArray[num].getNombre(i+1),i);//mueve los datos del animal de la posicion siguiente, a la anterior
										animalArray[num].setEdad(animalArray[num].getEdad(i+1),i);
										animalArray[num].setVacuna(animalArray[num].getVacunado(i+1),i);
										animalArray[num].setComer(animalArray[num].getComer(i+1),i);
										animalArray[num].setBanar(animalArray[num].getBanar(i+1),i);
									}
									animalArray[num].setNombre("",p);//borra lo datos de ultimo animal
									animalArray[num].setEdad(0,p);
									animalArray[num].setVacuna(false,p);
									animalArray[num].setComer(false,p);
									animalArray[num].setBanar(false,p);
									animalArray[num].cambiarPosicion(false);
									}
									}
									System.out.print("\nDesea eliminar otro de animal(S/N):");
									Scanner scan= new Scanner(System.in);//no funciona el scan si no lo coloco aqui
									op = scan.nextLine();
									if(op.equals("n") || op.equals("N")) f2=false;
									}while(f2==true);
								break;
							case 4: f2=true;
									do{//case para atender animall
									System.out.print("\nDe que tipo de animal desea atender.");
									num = datos.tipo();//saca la lista de tipos de animales 
									p = animalArray[num].getPosicion();//obtine la posicion del ultimo animaa en la lista
									if(p==0) System.out.print("\nNo se encuentrar animales registrados\n");
									else{
									nombreA = datos.nomTipo(num);//obtiene el String de tipo de animal
									System.out.print("\n\n--"+ nombreA+"--\n");
									for(i=0;i<p;i++){//saca la lista de los animales, con nombre y edad
										pos=i+1;
										System.out.println(""+pos+". "+animalArray[num].getNombre(i)+" | "+animalArray[num].getEdad(i)+" a\u00f1os");
									}			
									
									System.out.print("\nCual desea atender,ingrese el numero de la posicion:");
									a = sc.nextInt()-1;
									if(a<0 || a>p+1) System.out.println("\nPosicion no existente");
									else{
									System.out.print("\nQue desea hacer"+
													 "\n1.Dar alimento"+
													 "\n2.Asear"+
													 "\n3.Vacunar"+
													 "\n\nIngresa numero: ");
									i = sc.nextInt();
									
										switch(i){
											case 1: animalArray[num].comer(a); break;//metodos para mostrar la accion de atender
											case 2: animalArray[num].banar(a); break;
											case 3: animalArray[num].vacunar(a); break;
											default: System.out.println("\n--Ingresa una de las opciones--\n");
										}
									}									
									}
									System.out.print("\nDesea realizar otra accion(S/N):");
									Scanner scan= new Scanner(System.in);//no funciona el scan si no lo coloco aqui
									op = scan.nextLine();
									if(op.equals("n") || op.equals("N")) f2=false;
									
									}while(f2==true);
								break;
							case 5: f=false;//convierte la bandera de salida a falsa
								break;
							default: System.out.println("\n--Ingresa una de las opciones--\n");
						}
		}while(f==true); //bandera de salida	
	
	
	
	}
}

class Animal{
	int[] edad = new int[50];
	int i,c=0;
	String[] nombre = new String[50];
	boolean[] vacunado = new boolean[50],comer = new boolean[50],banar = new boolean[50];//booleano para revisar si ya se realizo antes
	
	public void inicializarAtributos(){
		for(i=0;i<50;i++){
			vacunado[i]=false;
			comer[i]=false;
			banar[i]=false;
			edad[i]=0;
			nombre[i]="";
		}
	}
	
	public Animal(){
	}
	
	public void setEdad(int edad,int i){
		this.edad[i] = edad;
	}
	
	public int getEdad(int i){
		return edad[i];
	}
	
	public void setNombre(String nombre,int i){
		this.nombre[i] = nombre;
	}
	
	public String getNombre(int i){
		return nombre[i];
	}
	public void setVacuna(boolean vacunado,int i){
		this.vacunado[i] = vacunado;
	}
	
	public boolean getVacunado(int i){
		return vacunado[i];
	}
	
	public void setBanar(boolean banar,int i){
		this.banar[i] = banar;
	}
	
	public boolean getBanar(int i){
		return banar[i];
	}
	
	public void setComer(boolean comer,int i){
		this.comer[i] = comer;
	}
	
	public boolean getComer(int i){
		return comer[i];
	}
	
	public void cambiarPosicion(boolean aumentar){
		if(aumentar==true) c++;
		else c--;
	}
	
	public int getPosicion(){
		return(c);
	}
	public void comer(int i){
		if(comer[i]==false){
		System.out.println("\n"+nombre[i] +" esta comiendo");
		comer[i]=true;
		}
		else System.out.println("\n"+nombre[i] +" ya se alimento antes");
	}
	
	public void banar(int i){
		if(banar[i]==false){
		System.out.println("\n"+nombre[i] +" ah sido aseado");
		banar[i]=true;
		}
		else System.out.println("\n"+nombre[i] +" ya ah sido aseado");
	}
	
	public void vacunar(int i){
		if(vacunado[i]==false){
		System.out.println("\n"+nombre[i] +" se ah vacunado");
		vacunado[i]=true;
		}
		else System.out.println("\n"+nombre[i] +" ya ah sido vacunado");
	}
}

class Elefante extends Animal{
	
	public Elefante(){
	}

	@Override
	
	public void comer(int i){
		if(comer[i]==false){
		System.out.println("\n"+nombre[i] +" esta comiendo hojas y raisaes");
		comer[i]=true;
		}
		else System.out.println("\n"+nombre[i] +" ya se alimento antes");
		
	}
}

class Jirafa extends Animal{
	
	public Jirafa(){
	}

	@Override
	
	public void comer(int i){
		if(comer[i]==false){
		System.out.println("\n"+nombre[i] +" esta comiendo hierva y fruta");
		comer[i]=true;
		}
		else System.out.println("\n"+nombre[i] +" ya se alimento antes");
		
	}
}

class Leon extends Animal{
	
	public Leon(){
	}

	@Override
	
	public void comer(int i){
		if(comer[i]==false){
		System.out.println("\n"+nombre[i] +" esta comiendo carne");
		comer[i]=true;
		}
		else System.out.println("\n"+nombre[i] +" ya se alimento antes");
		
	}
}

class Tigre extends Animal{
	
	public Tigre(){
	}

	@Override
	
	public void comer(int i){
		if(comer[i]==false){
		System.out.println("\n"+nombre[i] +" esta comiendo carne");
		comer[i]=true;
		}
		else System.out.println("\n"+nombre[i] +" ya se alimento antes");
		
	}
}

class Chimpanse extends Animal{
	
	public Chimpanse(){
	}

	@Override
	
	public void comer(int i){
		if(comer[i]==false){
		System.out.println("\n"+nombre[i] +" esta comiendo fruta");
		comer[i]=true;
		}
		else System.out.println("\n"+nombre[i] +" ya se alimento antes");
		
	}
}

class Loro extends Animal{
	public Loro(){
	}

	@Override
	
	public void comer(int i){
		if(comer[i]==false){
		System.out.println("\n"+nombre[i] +" esta comiendo semillsa");
		comer[i]=true;
		}
		else System.out.println("\n"+nombre[i] +" ya se alimento antes");
		
	}
	
	public void banar(int i){
		System.out.println("\n"+nombre[i] +" no nesecita asearse");
	}
	
	public void vacunar(int i){
		System.out.println("\n"+nombre[i] +" no nesecita vacunarse");
	}
}

class datosAnimal{//clase para obtener datos del animal
	int num;
	String nom;
	
	public datosAnimal(){
	}
	
	Scanner sc= new Scanner(System.in);
	
	public int tipo(){
		int num;
		boolean f=true;
		
		do{
		System.out.print("\nIngrese la opcion del animal deseado:"+
						 "\n1.Elefante"+
						 "\n2.Jirafa"+
						 "\n3.Leon"+
						 "\n4.Tigre"+
						 "\n5.Chimpanse"+
						 "\n6.Loro"+
						 "\n\nIngresa numero: ");
		num = sc.nextInt();
		if(num<0 || num>6) System.out.print("--Ingresa una de las opciones--\n");
		else f=false;
		}while(f==true);
		
		return(num-1);
	}
	
	public String nomTipo(int num){
		String nombre;
		switch(num){
			case 0: nombre = "Elefante"; break;
			case 1: nombre = "Jirafa"; break;
			case 2: nombre = "Leon"; break;
			case 3: nombre = "Tigre"; break;
			case 4: nombre = "Chimpanze"; break;
			case 5: nombre = "Loro"; break;
			default: nombre = "animal no existente"; break;
		}
		return(nombre);
	}
	public String nombre(){
		System.out.print("\nIngrese el nombre del animal: ");
		Scanner scan= new Scanner(System.in);
		return(scan.nextLine());
	}
	
	public int edad(){
		System.out.print("\nIngrese la edad del animal-en a\u00f1os: ");
		Scanner scan= new Scanner(System.in);//no funciona sin el scan dentro del metodo
		return(scan.nextInt());
	}
}