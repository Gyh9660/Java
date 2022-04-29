--10일차 Database Modeler
/*
    데이터베이스 모델링(설계)
    1. 요구사항 분석 : 업무의 요구사항을 연구 분석.
        - 시스템 개발을 위한 목표를 확립하는 과정,
            프로그램 방향을 설정하고 범위를 확정
        - 요구되는 정보가 무엇인지 정확하게 분석이 되지 않으면,
            프로그램 개발시 수시로 수정 사항이 생김. 치명적인 문제가 발생.
   개발의 80%~?
    
    2. 논리적 모델링 : 요구사항 정의서를 토대로 데이터 모델린 단계로 지행,
        - ER - 다이어그램 (Entity-Relatonashep Modeling) ;
        - 엔티티(Entity) : 네모로 표시, 객체, 테이블(물리적 모델링)
        - 속성 (Artribute) : 원으로 표시, 객체의 속성, 컬럼(물리적 모델링)
        - 관계 (Relationship) : 일대일, 일대다, 다대다
            - 엔티티와 엔티티 사이의 관계
            
    3. 물리적 모델링 : 논리적 모델링을 토대로 실제 구현하기위한 테이블,컬럼, 컬럼명
    
        테이블명 : 엔티티 ==> 테이블명
        컬럼명 : 속성 ==> 컬럼명 , 자료형
        foreign key : 테이블과 테이블의 관계설정,
    
    4. 구현 : 테이블 생성,
    
*/