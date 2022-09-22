import javax.swing.*;
import java.awt.*;

public class GuiButtonEx extends JFrame {

    //기본적인 화면 구성에 대한 설정을 생성자로 처리
    public GuiButtonEx() {
        //제목표시줄에 타이틀 출력
        setTitle("GUI 예제");
        //종료 버튼 클릭 시 프로그램 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //화면 요소를 담는 Container 생성.
        Container c = getContentPane();
        //화면 요소를 배치하는 레이아웃 설정
        c.setLayout(new FlowLayout());

        //버튼 추가
        JButton btn = new JButton("Action");
        c.add(btn);
        JButton btn2 = new JButton("Action2");
        c.add(btn2);

        //화면 크기 설정
        setSize(350, 150);
        //화면에 출력
        setVisible(true);
    }

    public static void main(String[] args) {
            new GuiButtonEx();
    }

}
