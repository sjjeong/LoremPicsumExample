# LoremPicsumExample

## 프로젝트 구성

- MVVM + MultiModule
- Compose
- Hilt
- Coil
- Paging3
- Kotlin Serialization
- Retrofit
- Room

## 모듈 구성

- app: Android Entry Point
- core
    - data: Repository로 DataSource에서 데이터를 가져옴
    - remote: Network 통신으로 데이터를 가져옴
    - local: Local DB에서 데이터를 저장하고 가져옴
    - ui: ui 관련 코드
- feature
    - photo_list: LoremPicsum에서 가져온 사진들을 나열한 화면
    - photo_detail: 하나의 사진의 정보를 보여주는 화면

## 화면
|list|detail|
|-|-|
|![image](https://github.com/user-attachments/assets/e40ec998-3c5d-4ffb-90a0-d76cc7b38d55)|![image](https://github.com/user-attachments/assets/866fe356-9083-47ff-8e1c-48d0c3ab6c1a)|

