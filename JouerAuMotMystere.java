
/**
 * @author Samir HAMOUDA
 * @version 2018-03-04
 * HAMS11087601
 * hb491067@ens.uqam.ca 
 */

public class JouerAuMotMystere{
    //------------------------------------------------------CONSTANT------------------------------------------------------------------------------
    public final static String PRESENTATION = 
        "_________________________________________________________\n" +
        " _____       _                        _                  \n" +
        "|     | ___ | |_     _____  _ _  ___ | |_  ___  ___  ___ \n" +
        "| | | || . ||  _|   |     || | ||_ -||  _|| -_||  _|| -_|\n" +
        "|_|_|_||___||_|     |_|_|_||_  ||___||_|  |___||_|  |___|\n" +
        "                           |___|                         \n" +
        "_________________________________________________________\n";

    public final static String MSG_MOT="Entrez un mot localise dans la grille (Q pour quitter) : ";
    public final static String MSG_ERREUR="\nERREUR ! Format invalide, recommencez...";
    public final static String MSG_CHOIX_SORTIE="Faire un autre mot mystere (oui / non) ?";

    //--------------------------------------------------------VARIABLE----------------------------------------------------------------

    //----------------------------------DÉBUT MÉTHODE D'AFFICHAGE DES GRILLE------------------     
    public static String grille(String chaine){
        /**
         * Cette methode extrait la grille de la classe TP2Utils  
         * est retourne un string grille 
         */
        chaine=chaine.substring(0, chaine.indexOf("#"));
        chaine=chaine.trim();
        return chaine;
    }

    public static String motMyster(String jeu){
        /**
         * Cette methode extrait la liste des mot est
         * les cordonnéd'emplacement de la classe TP2Utils  
         * est retourne un string liste 
         */
        String mot="";
        mot=jeu.substring(jeu.indexOf('#',jeu.indexOf('#')+1)+1);
        return mot;
    }

    public static int dimensionGrille(String chaine){
        /**
         * Cette methode extrait un string de la classe TP2Utils 
         * est retourne un string grille 
         */
        int dimension=0;
        chaine=chaine.substring(0, chaine.indexOf("#"));
        chaine=chaine.trim();
        dimension=chaine.length(); 

        return dimension;
    }

    public static boolean verificationReponse(String chaine,int dimension){
        /**
         * Retourne vrai si la saisie de l'utilisateur est correcte
         *  
         *  
         */


    
        String mot="";boolean sortie=true;char nbr1=0;char nbr2=0;char dire=0;
        int nbr3=0;char nbr4=0;char nbr5=0; char nbr6=0;int nbr7=0;char nbr8;
        String param=chaine.substring(chaine.indexOf(':')+1 );
        if (chaine==null||chaine.length()<9||!chaine.contains(":")||!chaine.contains(",")||param.length()>8){
            sortie=false;

        }else{
            mot=chaine.substring(0,chaine.indexOf(':'));
            mot=mot.toLowerCase();
            nbr1=chaine.charAt(mot.length()+1);nbr2=chaine.charAt(mot.length()+2);

            if(mot.length()<=2){sortie=false;}
            for (int i=0;i<mot.length();i++){
                if(mot.charAt(i)<'a'||mot.charAt(i)>'z'){sortie=false;}
            }

            if (dimension==19){
                if (Character.getNumericValue(nbr1)>4||nbr2!=','){
                    sortie=false;}else if(nbr2==','){
                    nbr4=chaine.charAt(mot.length()+3);
                    if(Character.getNumericValue(nbr4)>4){sortie=false;}
                }  

                if (dimension==71){
                    if(Character.getNumericValue(nbr1)>8||nbr2!=','){ 
                        sortie=false;}else if(nbr2==','){
                        nbr4=chaine.charAt(mot.length()+3);
                        if(Character.getNumericValue(nbr4)>8){sortie=false;}
                    }     
                }
            }
            if (dimension==155){
                nbr3=(10*Character.getNumericValue(nbr1))+Character.getNumericValue(nbr2);
                nbr4=chaine.charAt(mot.length()+3);
                nbr5=chaine.charAt(mot.length()+4); 
                if (Character.isDigit(nbr2)){
                         
                    if (nbr3>12||nbr4!=','){sortie=false;} //triangulaire:1,1:g
                     nbr6= chaine.charAt(mot.length()+5);                 
                    if (Character.isDigit(nbr6)){
                        nbr7=(10*Character.getNumericValue(nbr5))+Character.getNumericValue(nbr6);
                        nbr8=chaine.charAt(mot.length()+6);
                        if (nbr7>12||nbr8!=':'){sortie=false;}
                    } else {if (nbr6!=':'){sortie=false;}}

                }else {
                    if (Character.isDigit(nbr5)){
                      nbr7=(10*Character.getNumericValue(nbr5))+Character.getNumericValue(nbr4);
                      nbr6=chaine.charAt(mot.length()+5);
                      if (nbr7>12||nbr6!=':'){sortie=false;} 
                      }else {if (nbr5!=':'){sortie=false;}
                          }
                    
                } 

            } 
            dire=chaine.charAt(chaine.length()-1);
            
            if(Character.toLowerCase(dire)!='h'&&Character.toLowerCase(dire)!='b'&&Character.toLowerCase(dire)!='g'&&Character.toLowerCase(dire)!='d'){sortie=false;}
            dire=chaine.charAt(chaine.length()-2);
            if (Character.isLetter(dire)){sortie=false;}
        }
         
        return sortie; 
    }
    public static String afficheListe(int dimension){
       /**
         * Retourne les listes des mots a rechercher dans la grille
         *  
         */  
    String liste="";
    switch (dimension){
     case 19 :
     liste="abat, bleu, miel, pie,\n";
     break;
     case 71 :
     liste="tomate, bataille, femme, bienfait, pain, bambou,\ncalepin, placard, entier, bracelet, cent, olive,\ndiner,\n";
     break;
     case 155 :
     liste="albatros, gouttelette, grammaire, reflechir, triangulaire, entrevue,\nassurance, arbitrage, allergie,"+
            " engrenage, aiguillage, cantaloup,\nouragan, violoncelle, carrefour, beau, museau, phare,\ncroupier, couplet, elfe,\n"; 
     }
    return liste;
    }
    public static String remplceMot(String chaine,String mot){
      /**
         * Retourne une liste String et suprime le mot trouver 
         *  
         *  
         */
      mot=mot+",";
      chaine=chaine.replace(mot, "");
      return chaine;
    }

    public static void afficheGrille(String chaine,int dimension){
        /**
         * affiche la grille 
         *  
         *  
         */
        String liste="";
        int k=1;
        int d;int vertical=0;int horizontal=0;String ligne="";
        
        switch (dimension){
            case 19:
            horizontal=4;
            vertical=18;
            ligne="------------------\n";
            break;
            case 71 :
            horizontal=8;
            vertical=70;
            ligne="----------------------------------\n";
            break;
            case 155 :
            horizontal=12;
            vertical=154;
            ligne="---------------------------------------------------\n";
            break;
        }             
        for (int i=1;i<=horizontal;i=i+1){
            System.out.print("   "+i);

        }

        System.out.print("\n"+"  "+ligne+k);
        for (int j=0 ;j<=vertical ;j=j+1){
            System.out.print(" | "+chaine.charAt(j));
            if (chaine.charAt(j)=='\n'){
                System.out.print("  "+ligne+(k=k+1));
            }
        }
        System.out.print(" | "+"\n"+"  "+ligne+"\n LISTE DE MOTS\n----------------\n");
        
        

    }

   

    //****************************************************************************

    //**************************************************************************
    public static String motMiniscule(String jeu, String reponse){
        /**
         * Remplace les lettre majiscule par des lettre miniscule et rerourne la grille 
         *  
         *  
         */
    
        char c=0;int x=0;int y=0;char direction=0;int dimension=19;int j=0; 
        reponse=reponse.substring(reponse.indexOf(':')+1 );  //gouttelette:12,12:h
        if (dimension==19||dimension==71){
         x=Character.getNumericValue(reponse.charAt(0));y=Character.getNumericValue(reponse.charAt(2));direction=reponse.charAt(4);
         }else { 
           if (Character.isDigit(reponse.charAt(1))&&Character.isDigit(reponse.charAt(4))){
            x=(10*Character.getNumericValue(reponse.charAt(0)))+Character.getNumericValue(reponse.charAt(1));
            y=(10*Character.getNumericValue(reponse.charAt(3)))+Character.getNumericValue(reponse.charAt(4));
            direction=reponse.charAt(6);
           }else if(!Character.isDigit(reponse.charAt(1))&&Character.isDigit(reponse.charAt(4))){
            x=Character.getNumericValue(reponse.charAt(0)); 
            y=(10*Character.getNumericValue(reponse.charAt(2)))+Character.getNumericValue(reponse.charAt(3));
            direction=reponse.charAt(5);
            }else if(Character.isDigit(reponse.charAt(1))&&!Character.isDigit(reponse.charAt(4))){
            x=(10*Character.getNumericValue(reponse.charAt(0)))+Character.getNumericValue(reponse.charAt(1));
            y=Character.getNumericValue(reponse.charAt(3));
            direction=reponse.charAt(5);
             }else if (!Character.isDigit(reponse.charAt(1))&&!Character.isDigit(reponse.charAt(4))){
              x=Character.getNumericValue(reponse.charAt(0));
              y=Character.getNumericValue(reponse.charAt(2));
              direction=reponse.charAt(5);
           }
         }
        switch (Character.toLowerCase(direction)){
            case 'b' :
            j=3;
            for(int i=0;i<jeu.length()&&j<19;i++){
              c=jeu.charAt(j);
              jeu=jeu.substring(0,j)+Character.toLowerCase(c)+jeu.substring(j+1);
              j=j+5;            
            }

            break;
            case 'h':
            j=16;
            for(int i=0;i<jeu.length()&&j>0;i++){
              c=jeu.charAt(j);
              jeu=jeu.substring(0,j)+Character.toLowerCase(c)+jeu.substring(j+1);
              j=j-5;            
            }
            break;
            
            case 'g':
            j=8;
            for(int i=0;i<jeu.length()&&j>4;i++){
              c=jeu.charAt(j);
              jeu=jeu.substring(0,j)+Character.toLowerCase(c)+jeu.substring(j+1);
              j--;            
            }
            break;
            case 'd':
            j=10;
            for(int i=0;i<jeu.length()&&j<13;i++){
              c=jeu.charAt(j);
              jeu=jeu.substring(0,j)+Character.toLowerCase(c)+jeu.substring(j+1);
              j++;
            }
        }
        return jeu;
    }
    //***************************************************************************

    //------------------------------------DÉBUT DE LA METHODE MAIN------------------------------ 
    public static void main (String [] args){
        String jeu ="";String reponse1=""; String grille="";String motmyster;
        String liste="";int dimension=0;String reponse2="";String reponse3="";
        
        System.out.println(PRESENTATION);
        
        do{
            jeu = TP2Utils.obtenirJeu();
            dimension=dimensionGrille(jeu);
            liste=afficheListe(dimension);
            grille=grille(jeu);
            afficheGrille(grille,dimension);
            System.out.println(liste);
            System.out.print(MSG_MOT);
            
            reponse1=Clavier.lireString();
            while(reponse1.isEmpty() || !verificationReponse(reponse1,dimension) && !reponse1.equalsIgnoreCase("q")) {             
                System.out.println(MSG_ERREUR);         
                System.out.print(MSG_MOT);
                reponse1=Clavier.lireString();
            }

            while (!reponse1.isEmpty()&& !reponse1.equalsIgnoreCase("q")&&verificationReponse(reponse1,dimension)){
                grille=motMiniscule(grille, reponse1);
                afficheGrille(grille,dimension);
                reponse1=reponse1.substring(0,reponse1.indexOf(':'));
                liste=remplceMot(liste,reponse1);
                
                if(liste.length()==4){
                   System.out.println("Vous avez trouve tous les mots !");
                   reponse3=Clavier.lireString();  
                                 
                   if (reponse3.equalsIgnoreCase(motMyster(jeu))){
                     System.out.print("BRAVO !");
                     break;
                              }else  { 
                               System.out.println("ECHEC ! Le mot mystere etait"+motMyster(jeu));
                               reponse1="q";
                                        }

                    }else {
                      System.out.println(liste);
                      System.out.print(MSG_MOT);
                      reponse1=Clavier.lireString();
                    }
                
            }
            
            if (reponse1.equalsIgnoreCase("q")){
                System.out.println(MSG_CHOIX_SORTIE);
                reponse2=Clavier.lireString();
                while (!reponse2.equalsIgnoreCase("oui")&&!reponse2.equalsIgnoreCase("non")){
                    System.out.println("ERREUR ! Vous devez repondre par oui ou non, recommencez...");
                    System.out.print("Faire un autre mot mystere (oui / non) ?");
                    reponse2=Clavier.lireString();
                }

            }
        
        }while(reponse2.equalsIgnoreCase("oui"));
        System.out.print("AUREVOIR"); 
    }

    //-------------------------------------FIN DE LA MÉTHODE MAIN-------------------------------   

}
//------------------------FIN DE LA CLASSE JouerAuMotMystere------------------
