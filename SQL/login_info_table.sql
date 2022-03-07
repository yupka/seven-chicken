void findId() {

        	 String id = "";
        	 String mileage = "";

        	 connect();

        	 sql = "select login_id from login_info where login_no = (select max(login_no) from login_info)";

        	 try {

        		 pstmt = con.prepareStatement(sql);
        		 rs = pstmt.executeQuery();

        		 while(rs.next()) {

	        		 id = rs.getString("login_id");

	        		 if(id.equals("비회원")) {

	        			 JOptionPane.showMessageDialog(null, "비회원은 마일리지를 사용하실 수 없습니다.");

	        	       } else {

    	        			String sql2 = "select mem_point from membertable where mem_id = ?";
    	        			pstmt = con.prepareStatement(sql2);
    	        			pstmt.setString(1, id);
    	        			rs = pstmt.executeQuery();

	        			        while(rs.next()) {

	        				           mileage = rs.getString("mem_point");

	        			             } // while 문 end

	        			    int result = JOptionPane.showConfirmDialog(null, "보유하신 마일리지는 [ " + mileage + " ] 입니다. 사용하시겠습니까?", "마일리지 사용", JOptionPane.YES_NO_OPTION);

    	        			if(result == JOptionPane.YES_OPTION) {

	    				           } else if(result == JOptionPane.NO_OPTION) {
	    					               JOptionPane.showMessageDialog(null, "마일리지 사용 취소");
	    				                  }
	        		            }

             } 

        	 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        } // findId 메서드