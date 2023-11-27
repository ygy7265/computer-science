import java.util.Iterator;

//메뉴정보
class Menu {
    private String name;

    public Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
//Iterator 구현
class MenuListIterator implements Iterator<Menu> {
    //메뉴 리스트
    private MenuList menuList;
    //현재 메뉴 위치
    private int index = 0;
    //생성자
    public MenuListIterator(MenuList menuList) {
        this.menuList = menuList;
    }
    // 리스트 크기만큼
    @Override
    public boolean hasNext() {
        return index < menuList.getLength();
    }
    // 요소 하나씩반환
    @Override
    public Menu next() {
        Menu menu = menuList.getMenu(index);
        index++;
        return menu;
    }
}

//집합체 인터페이스
interface Aggregate {
    public abstract Iterator createIterator();
}

class MenuList implements Aggregate {
    private Menu[] menus; //메뉴 리스트
    private int last = 0; //인덱스값

    public MenuList(int size) {
        menus = new Menu[size];
    }

    public Menu getMenu(int index) {
        return menus[index];
    }
    //리스트 크기
    public int getLength() {
        return last;
    }
    //리스트에 요소 넣기
    public void addMenu(Menu menu) {
        if (last < menus.length) {
            this.menus[last] = menu;
            last++;
        }
    }


    @Override
    public Iterator createIterator() {
        return new MenuListIterator(this);
    }
}

public class IteratorPattern {
    public static void main(String[] args) {
        //리스트 생성
        MenuList menuList = new MenuList(5);
        //요소초기화
        Menu menu1 = new Menu("chicken");
        Menu menu2 = new Menu("pizza");
        Menu menu3 = new Menu("toast");

        //요소넣기
        menuList.addMenu(menu1);
        menuList.addMenu(menu2);
        menuList.addMenu(menu3);
        System.out.println("메뉴 갯수 : " + menuList.getLength());

        //이터레이터 구현
        Iterator iterator = menuList.createIterator();

        //하나씩 요소 찾기j
        while (iterator.hasNext()) {
            Menu menu = (Menu) iterator.next();
            System.out.println(menu.getName());
        }

    }
}
