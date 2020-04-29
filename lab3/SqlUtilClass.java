package lab3;

import java.lang.reflect.*;
import java.util.List;

public class SqlUtilClass implements SqlUtil{
	@Override
	public String query(User user) {
		String output = "SELECT * FROM ";
		try {			
			Class<?> clazz = user.getClass();
			Table t = (Table)clazz.getAnnotation(Table.class);
			output += t.value() + " WHERE ";
			Field[] f = clazz.getDeclaredFields();
			for(Field item:f) {
				item.setAccessible(true);
				Column col = item.getAnnotation(Column.class);
				if(col.value().equals("id") && (int)item.get(user) != 0) {
					output += "id=" + (int)item.get(user) + " ";
				}
				if(col.value().equals("username") && !item.get(user).equals("")) {
					output += "username LIKE" + " '" + item.get(user) + "' ";
				}
				if(col.value().equals("age") && (int)item.get(user) != 0) {
					output += "age=" + (int)item.get(user)+" ";
				}
				if(col.value().equals("email") && !item.get(user).equals("")) {
					output += "email LIKE " + "'" + item.get(user) + "' ";
				}
				if(col.value().equals("telephone") && !item.get(user).equals("")) {
					output += "telephone LIKE " + "'"+item.get(user) + "'";
				}
			}
			output += ";";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public String insert(User user) {
		String output = "INSERT INTO ";
		try {
			Class clazz = user.getClass();
			Table t = (Table)clazz.getAnnotation(Table.class);
			output += t.value()+" (";
			Field[] f = clazz.getDeclaredFields();
			for(int i = 0; i < f.length; i++) {
				f[i].setAccessible(true);
				if(f[i].getAnnotation(Column.class).value().equals("id") || f[i].getAnnotation(Column.class).value().equals("age")) {
					if((int)f[i].get(user) == 0){
						continue;
					}
				}else {
					if(f[i].get(user).equals("")) {
						continue;
					}
				}
				output += f[i].getAnnotation(Column.class).value();
				if(i != f.length - 1) {
					output += ",";
				}else {
					output += ") VALUES (";
				}
			}
			for(int i = 0; i < f.length; i++) {
				f[i].setAccessible(true);
				if(f[i].getAnnotation(Column.class).value().equals("id") || f[i].getAnnotation(Column.class).value().equals("age")) {
					if((int)f[i].get(user) == 0){
						continue;
					}
				}else {
					if(f[i].get(user).equals("")) {
						continue;
					}
				}
				output += f[i].get(user);
				
				if(i != f.length - 1) {
					output += ",";
				}else {
					output += ")";
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		output += ";";
		return output ;
	}

	@Override
	public String insert(List<User> users) {
		String output = "INSERT TO ";
		try {
			Class clazz = users.get(0).getClass();
			Table t = (Table)clazz.getAnnotation(Table.class);
			output += t.value() + " (";
			Field[] f = clazz.getDeclaredFields();
			for(int i = 0; i < f.length; i++) {
				f[i].setAccessible(true);
				if(f[i].getAnnotation(Column.class).value().equals("id")||f[i].getAnnotation(Column.class).value().equals("age")) {
					if((int)f[i].get(users.get(0)) == 0){
						continue;
					}
				}else {
					if(f[i].get(users.get(0)).equals("")) {
						continue;
					}
				}
				output +=f[i].getAnnotation(Column.class).value();
				if(i != f.length - 1) {
					output += ",";
				}else {
					output += ") VALUES (";
				}
			}
			for(int i = 0; i < users.size(); i++) {
				Class clazz1 = users.get(i).getClass();
				Table tx1 = (Table)clazz1.getAnnotation(Table.class);
				Field[] f1 = clazz1.getDeclaredFields();
				for(int j = 0; j < f1.length; j++) {
					f1[j].setAccessible(true);
					if(f[j].getAnnotation(Column.class).value().equals("id")||f1[j].getAnnotation(Column.class).value().equals("age")) {
						if((int)f1[j].get(users.get(i)) == 0){
							continue;
						}
					}else {
						if(f1[j].get(users.get(i)).equals("")) {
							continue;
						}
					}
					output += f1[j].get(users.get(i));
					
					if(j != f1.length - 1) {
						output += ",";
					}else if(i != users.size() - 1){
						output += "),(";
					}else {
						output += ")";
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		output += ";";
		return output;
	}

	@Override
	public String delete(User user) {
		String output = "DELETE FROM ";
		try {
			Class clazz = user.getClass();
			Table t = (Table)clazz.getAnnotation(Table.class);
			output += t.value()+" WHERE ";
			Field[] f = clazz.getDeclaredFields();
			for(Field item:f) {
				item.setAccessible(true);
				Column co = item.getAnnotation(Column.class);
				if(co.value().equals("id") && (int)item.get(user) != 0) {
					output += "id=" + (int)item.get(user) + " ";
				}
				if(co.value().equals("username") && !item.get(user).equals("")) {
					output += "username LIKE" + " '" + item.get(user) + "' ";
				}
				if(co.value().equals("age") && (int)item.get(user)!=0) {
					output += "age=" + (int)item.get(user) + " ";
				}
				if(co.value().equals("email") && !item.get(user).equals("")) {
					output += "email LIKE " + "'" + item.get(user) + "' ";
				}
				if(co.value().equals("telephone") && !item.get(user).equals("")) {
					output += "telephone LIKE " + "'" + item.get(user) + "'";
				}
			}
			output += ";";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public String update(User user) {
		String output ="UPDATE ";
		Class clazz = user.getClass();
		Table t = (Table)clazz.getAnnotation(Table.class);
		output += t.value()+" SET ";
		Field[] f = clazz.getDeclaredFields();
		try {
			for(int i = 1; i < f.length; i++) {
				f[i].setAccessible(true);
				if(f[i].getAnnotation(Column.class).value().equals("age")) {
					if((int)f[i].get(user) == 0){
						continue;
					}
				}else {
					if(f[i].get(user).equals("")) {
						continue;
					}
				}
				output += f[i].getAnnotation(Column.class).value() + "="+f[i].get(user) + " ";
			}
			f[0].setAccessible(true);
			output += "WHERE " + f[0].getAnnotation(Column.class).value() + "=" + f[0].get(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
		output += ";";
		return output;
	}
	

}
