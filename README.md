# MemberManagement 배포 과제

## 목차
- [LV 0 - 요금 폭탄 방지 AWS Budget 설정](#lv-0---요금-폭탄-방지-aws-budget-설정)
- [LV 1 - 네트워크 구축 및 핵심 기능 배포](#lv-1---네트워크-구축-및-핵심-기능-배포)
- [LV 2 - DB 분리 및 보안 연결하기](#lv-2---db-분리-및-보안-연결하기)
- [LV 3 - 프로필 사진 기능 추가와 권한 관리](#lv-3---프로필-사진-기능-추가와-권한-관리)
- [LV 4 - Docker & CI/CD 파이프라인 구축](#lv-4---docker--cicd-파이프라인-구축)
- [LV 5 - 고가용성 아키텍처와 보안 도메인 연결](#lv-5---고가용성-아키텍처와-보안-도메인-연결-alb--asg--https)

---

## LV 0 - 요금 폭탄 방지 AWS Budget 설정

**설정 완료된 AWS Budgets 화면**

<img width="1142" height="795" alt="AWS Budgets 설정 화면" src="https://github.com/user-attachments/assets/17edac91-7950-46ff-bf68-cfc339344862" />

---

## LV 1 - 네트워크 구축 및 핵심 기능 배포

**설정 완료된 EC2의 퍼블릭 IP**

<img width="1150" height="648" alt="EC2 퍼블릭 IP" src="https://github.com/user-attachments/assets/390dd2ff-3ab9-401c-b0c9-21ed8084a197" />

> **퍼블릭 IP** : `43.201.19.27`

---

## LV 2 - DB 분리 및 보안 연결하기

### 1. Actuator Info 엔드포인트 URL

> **퍼블릭 엔드포인트 URL** : `http://43.201.19.27:8080/actuator/info`
>
> ⚠️ 뒤 과제를 진행하며 변경한 내용으로 인해 현재는 작동하지 않습니다.

### 2. RDS 보안 그룹 스크린샷

<img width="1140" height="233" alt="RDS 보안 그룹 스크린샷" src="https://github.com/user-attachments/assets/d4252782-c9c7-48bd-afb2-69733f12d4d6" />

---

## LV 3 - 프로필 사진 기능 추가와 권한 관리

> IAM Role로 진행하여 발제에서 요구하는 Presigned URL 대신 **접근 성공 스크린샷**을 첨부합니다.

**프로필 사진 업로드**

<img width="472" height="291" alt="프로필 사진 업로드" src="https://github.com/user-attachments/assets/c6aefd9b-e14e-477a-bfd1-5cf34c7a2355" />

**프로필 사진 다운로드**

<img width="456" height="542" alt="프로필 사진 다운로드" src="https://github.com/user-attachments/assets/693b7dda-6e5f-4434-a6e2-ecb721f0403a" />

**프로필 사진 확인**

<img width="685" height="524" alt="프로필 사진 확인" src="https://github.com/user-attachments/assets/45f16f92-c3ad-4e6a-a950-ea630943312b" />

---

## LV 4 - Docker & CI/CD 파이프라인 구축

### 1. GitHub Actions 성공 이미지

<img width="1149" height="556" alt="GitHub Actions 성공 화면" src="https://github.com/user-attachments/assets/d170bfac-6c20-4601-a83a-eca204fc79f7" />

### 2. EC2 터미널 이미지

`sudo docker ps` 실행 결과, 컨테이너가 정상적으로 실행 중인 것을 확인했습니다.

<img width="1243" height="366" alt="EC2 docker ps 실행 결과" src="https://github.com/user-attachments/assets/2da7c2a7-f520-4f18-b166-dc8767019e6c" />

---

## LV 5 - 고가용성 아키텍처와 보안 도메인 연결 (ALB + ASG + HTTPS)

### 1. HTTPS 적용된 도메인 URL

> **예시 URL** : https://member-management-jm.click/api/members/1

<img width="335" height="271" alt="HTTPS 도메인 접속 화면" src="https://github.com/user-attachments/assets/17884f08-aaa4-4012-b897-f3b443ca7755" />

### 2. Target Group(대상 그룹) 이미지

<img width="1152" height="540" alt="Target Group 등록된 대상 상태" src="https://github.com/user-attachments/assets/c6e61db1-14bf-4640-8c38-190e265fd5c0" />
