package model;
public interface ActionsAndAll{
	public enum Does {
		FLY, APPEAR, RING, RUN_TO_OPEN, STAND, COOK_TO_YU, HEAR, TURN, SPLASH,RESH;
		
	}
	public enum Mood {
		BESH,REZ,PRO_SEBYA;
	}
	public enum Place {
		WINDOW, DOOR, OVEN1, OVEN2, BACK;
		
	}
	public enum Subj {
		CHICK, POL_WITH_CAKE, MORE_EASY,DOOR; 
	}
	
	 public static String getDo(Does runToOpen, boolean male){
			switch (runToOpen){
	        case FLY: {
	            if(male){
	            	return(" ������");
	            }else{
	            	return(" �������");
	            }
	            
	        }
	        case APPEAR: {
	        	if(male){
	        		return(" ��������");
	        	}else{
	        		return(" ���������");
	        	}

	        }
	        case RING: {
	        	if(male){
	        		return(" �����������");
	        	}else{
	        		return(" ������������");
	        	}

	        }
	        case RUN_TO_OPEN: {
	        	if(male){
	        		return(" ������� ���������");
	        	}else{
	        		return(" �������� ���������");
	        	}

	        }
	        case STAND: {
	        	if(male){
	        		return(" �����");
	        	}else{
	        		return(" ������");
	        	}

	        }
	        case COOK_TO_YU: {
	        	if(male){
	        		return(" ��� �����, ����� ������ ���� ������");
	        	}else{
	        		return(" ����� �����, ����� ������ ���� ������");
	        	}

	        }
	       
	        case HEAR: {
	        	if(male){
	        		return(" �������");
	        	}else{
	        		return(" ��������");
	        	}

	        }
	        case TURN: {
	        	if(male){
	        		return(" ���������");
	        	}else{
	        		return(" ����������");
	        	}

	        }
	        case SPLASH: {
	        	if(male){
	        		return(" ���������");
	        	}else{
	        		return(" ����������");
	        	}

	        }
	        default: {
	        	if(male){
	        		return(" ������ ���-��");
	        	}else{
	        		return(" ������� ���-��");
	        	}
	        }
	        case RESH: {
	            if(male){
	            	return(" �����");
	            }else{
	            	return(" ������");
	            }
	 
	        }
	    }
		}
	    public static String getSubj(Subj pl){
			switch (pl){
	        case MORE_EASY: {
	            return(" ����-�� ����� �������");
	 
	        }
	        case DOOR: {
	        	return(" ������� �����");

	        }
	        case POL_WITH_CAKE: {
	        	return(" ����� �������� ������� �����");

	        }
	        case CHICK: {
	        	return(" ��������");

	        }
	        
	        default: {
	        	return(" ���-��");
	        }
	    }
		}
		
	    public static String getPlace(Place pl){
			switch (pl){
	        case WINDOW: {
	            return(" � ����");
	 
	        }
	        case DOOR: {
	        	return(" �� ������� �����");

	        }
	        case OVEN1: {
	        	return(" � �����");

	        }
	        case OVEN2: {
	        	return(" �� �����");

	        }
	        case BACK: {
	        	return(" �� ������");

	        }
	        default: {
	        	return(" ���-��");
	        }
	    }
		}
	    public static String getMood(Mood pl){
			switch (pl){
	        case REZ: {
	            return(" �����");
	 
	        }
	        case BESH: {
	        	return(" ������");

	        }
	        case PRO_SEBYA: {
	        	return(" ��� ����");

	        }
	 
	        default: {
	        	return(" ���-��");
	        }
	    }
		}

}
