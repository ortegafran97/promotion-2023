cd ProductsABM;
cd ./config-service;
echo "~~~~~~~ Build config ~~~~~~~";
./gradlew build;

cd ../discovery-service/;
echo "~~~~~~~ Build eureka ~~~~~~~";
./gradlew build;

cd ../gateway-service/;
echo "~~~~~~~ Build gateway ~~~~~~~";
./gradlew build;

cd ../products-service/;
echo "~~~~~~~ Build products ~~~~~~~";
./gradlew build;

cd ../stock-service/;
echo "~~~~~~~ Build stock ~~~~~~~";
./gradlew build;

cd ../category-service/;
echo "~~~~~~~ Build category ~~~~~~~";
./gradlew build;


cd ..