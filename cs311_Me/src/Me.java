import java.util.Scanner;


public class Me {private static char[] characters = {'α','ß','γ','δ','ε','ζ','η','θ','ι','κ'};
private static char[] vars = {'a','b','c'};

	public static void main(String[] args){
		@SuppressWarnings("resource")
		Me meObject = new Me();
		Scanner input = new Scanner(System.in);
		System.out.println("For a single character expression enter 1 else enter 2 for a two character expression");
		int mode = input.nextInt();
		input.nextLine();
		
		if(mode == 2){
			for(int i = 1; i<11;i++)
				System.out.print(i + " ");
			System.out.println();
			for(int i = 0; i<10;i++)
				System.out.print(characters[i] + " ");
			System.out.println();
			System.out.println("Please enter the number of the first symbol you wish to use");
			int expr1 = input.nextInt();
			input.nextLine();
			System.out.println("Please enter a + or *");		
			String operator = input.next();	
			System.out.println();
			for(int i = 1; i<14;i++)
				System.out.print(i + " ");
			System.out.println();
			for(int i = 0; i<10;i++)
				System.out.print(characters[i] + " ");
			for(int i = 0; i<3;i++)
				System.out.print(vars[i] + " ");
			System.out.println("Please enter number of the second symbol you wish to use");				
			int expr2 = input.nextInt();
			input.nextLine();
			char expr3;
			if(expr2 > 9){
				expr3 = vars[expr2-11];
			}
			else{
				expr3 = characters[expr2-1];
			}
			System.out.println("Please enter a paired sturucture similar to \"" + expr3 + ", <value>\"");
			String s = input.nextLine();
			String expr = characters[expr1-1] + operator + expr3;					
			int result = meObject.Me(expr,s);
			System.out.println("The results from the expression \"" + expr + "\" is: " + result);
		}else{
			for(int i = 1; i<14;i++)
				System.out.print(i + " ");
			System.out.println();
			for(int i = 0; i<10;i++)
				System.out.print(characters[i] + " ");
			for(int i = 0; i<3;i++)
				System.out.print(vars[i] + " ");
			System.out.println("Please enter number of the symbol you wish to use");
			int symbol = input.nextInt();
			input.nextLine();
			String s = null;
			int result;
			if(symbol > 10){
				System.out.println("Please enter a structure similar \"" + vars[symbol-11] + ",<value>\"");
				s = input.nextLine();
				String str = String.valueOf(vars[symbol-11]);
				result = meObject.Me(str,s);
				System.out.println("The results from the expression \"" + vars[symbol-11] + "\" is: " + result);
			}else{	
				String str = String.valueOf(characters[symbol-1]);
				result = meObject.Me(str,s);
				System.out.println("The results from the expression \"" + characters[symbol-1] + "\" is: " + result);
			}
			
			
		}
	
	}		
	
	public int Me(String expr,String s){
		String identifier = exprVal(expr);
		
		switch(identifier){
			case"dec_num": return Mdec(expr.charAt(0));
			case"var": 
				s.replaceAll("\\s", "");
				return VARMAP(s.charAt(0),s.substring(2));
			case"Binary_Expr": 
				expr.replaceAll("\\s", "");
				if((Me(expr.substring(0,1), s) == -1) || (Me(expr.substring(2,3), s) == -1)){
					System.out.println("An Error Has Occured");
					System.exit(-1);
				}else{					
					if(expr.substring(1,2).equals("+")){
						return Me(expr.substring(0,1),s) + Me(expr.substring(2,3), s);
					}else{
						return Me(expr.substring(0,1),s) * Me(expr.substring(2,3), s);
					}
				}
			default: return -1;							
		}	
		
	}
	
	private static int Mdec(char decNum){
		
		switch(decNum){
			case 'α': return 0;//dec
			case 'ß': return 1;//dec
			case 'γ': return 2;//dec
			case 'δ': return 3;//dec
			case 'ε': return 4;//dec
			case 'ζ': return 5;//dec
			case 'η': return 6;//dec
			case 'θ': return 7;//dec
			case 'ι': return 8;//dec
			case 'κ': return 9;//
		
		}
		return -1;
	}	
	
	private static String exprVal(String expr){
		if(expr.length() == 1){
			if(isVar(expr)){
				return "var";
			}else{
				if(isOperator(expr))
					return "operator";
				return "dec_num";
			}				
		}else{
			if(expr.length()>1)
				return"Binary_Expr";
		}		
		
		return null;
	}
	
	private static boolean isVar(String expr){
		if(expr.equals("a") || expr.equals("b") || expr.equals("c"))
			return true;
		return false;
	}
	
	private static boolean isOperator(String expr){
		if(expr.equals("+") || expr.equals("*")){
			return true;
		}
		return false;
	}
	private static int VARMAP(char var, String s){		
		int VAR = Integer.parseInt(s);
		return VAR;		
	}

}
