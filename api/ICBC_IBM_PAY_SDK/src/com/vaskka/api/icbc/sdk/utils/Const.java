package com.vaskka.api.icbc.sdk.utils;

/**
 * @program: ICBC_IBM_PAY_SDK
 * @description: Const 各种常量
 * @author: Vaskka
 * @create: 2018/10/10 上午12:01
 **/

public class Const {
    /**
     * debug标志
     */
    public static final boolean DEBUG = true;

    /**
     * 沙箱环境
     */
    public static final String SANDBOX_HOST = "https://apisandbox.dccnet.com.cn/api";

    /**
     * 实测环境
     */
    public  static final String REAL_HOST = "https://gw-api-iicamp.dccnet.com.cn/api";

    /**
     * app id
     */
    public  static final String APP_ID = "IICAMP0000000803";

    /**
     * 私钥
     */
    public  static final String MY_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDFczzJ7uVAV8s8vvVAMj14Pl5o50qhIug3Ob+M0BbbzEQ6QhrCImvgojq0LiYMfC4AzHPkJV6j7iyzAIvSJVmYPZPZrdA3OHLXFT0QhUFO177+IbLTU7VzLy4zIDQ+NMtDV7ADUv0Fk4xaQm5wBsYUEbAYz4Kp0q4dyHIINc/Dn7JfZxGkQvjOlykP5Z/hwhMWi/JKWrlsX+Vwtdp4oCRjWxld6gpIjschk9jhVGkol+G/nKdH1qRVQP8qs3rCIm1TY/8bwvhm3IMQKFqqsxBdIc4qGsUkAU82d6UGbx2Y7NgVXUy3dQCG4OgCE78npXR8xwVNS6sk//WgfHgbpw9bAgMBAAECggEADuX4E0CMWcOGGUpLVRG1Y6pJE19IWUo5/VjFJEnbP7B1AXRVcoqIW0XCajAFPPHtwq+qmu9a6cGh68vBwRSCYyNaUZV03YXL3IDEv8deOyW6SpCeXqW1TkCkGsV2S69OGwG1zTpozw/oCjNzA87vCTqgb+7QbCHyc1rZh9cPmzICo/2gFDgwUv7iuZ2ENwMrAjRi9U0+sHBh8RS78TPFoJdeAQjjJZY7ZPJn8Oig25ZNGbqU61BlLWkv/8txegXnt57jyKncF0AFepGkKDkclY8Kp/UuYJR52PAk4kR9RRycEy/b00L424wVOBPJEbgikIrgrH0GRXJVTxGKVSEjiQKBgQDj7Ox/iM0JnUDygjQe2hcwQr4CuLi2413uf34J0MIPGYA+/lPYkGLqXbIztR6Nlo0VzJOBjxz1SQvM1psm2KIxD5aLAo/DKVnKvRPsRpRPsK3oPaw+yMQIoSu0TeShJ3wWZWkDdqNnT1rMd7wVRGP7iZmXiMZAvgv6PTZdqqg/5wKBgQDdxVkSgOo7cIlS8vEjMkEEMwov4ffym0dQ5MIkUYflVMdOG+38X1C5I3VMKilx8xoId1/7o26KdOslINICw+WCimJ6EzaV8KCNosxvH3W8PRBwGKa6p+rjbFjxlGL1SzBlwVoq9jq8cexCxfsKXCB7CZIb8/Ulhj4GZNWw5ooWbQKBgGUjZ9o7wQgIIJ67yhb6nZmLtDcO8uAsyiyfpDUEzmfW4AKT5m7NuybWRtINB666ZIaMzdOKxsXNERBnFlfJf0cX7KxoiZSHT9HXzvRkaUFnW/QXEcyWV+6gXf1XJyGfnL9vZobj6SRZoSfj5bDmNRuT9nS4e4iVDEmRSgOMS7Z3AoGBAJOAP9cLwT7ZgayXAwVa1l15qQvh6q0E1DEchXfsdkt00L7F2srhhmotCEYpQLmWbDk3VLKkp9AVJZTjOGs4af0iF4+EGekuS0sI/ZnnPcJ+huFXtAUvzA2JMbsz64GkicMUD+nFLZnK184tqePhFIVg/znyT5muqLBN/scS/sMdAoGAJSnQnZRAl7oQEy8k4+fwd7sZrJ35JJ412whvJKPSxYE8K6ycIjOs/AyDLBMuPUhz4V7xg/xapiid9e6F2/MF0SlrOI6xqkKgJQYV0hqnoY2TWkpsmHLpNY04HNmyn9fQrS+K6He/R9I+opzWxGVf0BreCvSGfgRtkJnOQrM04So=";

    /**
     * 网关公钥
     */
    public  static final String APIGW_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwFgHD4kzEVPdOj03ctKM7KV+16bWZ5BMNgvEeuEQwfQYkRVwI9HFOGkwNTMn5hiJXHnlXYCX+zp5r6R52MY0O7BsTCLT7aHaxsANsvI9ABGx3OaTVlPB59M6GPbJh0uXvio0m1r/lTW3Z60RU6Q3oid/rNhP3CiNgg0W6O3AGqwIDAQAB";


    /**
     * 商户档案编号
     */
    public  static final String MER_ID = "020004040045";

    /**
     * e生活档案编号
     */
    public  static final String STORE_CODE = "02000014415";

    /**
     * 生成二维码有效期
     */
    public static final String  PAY_EXPIRE = "1200";

}
