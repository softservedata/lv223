package third332;

import java.util.Scanner;

/*
 * 
 */
public class Main {
/*
 * 
 */
	public static void main(String[] args) {
		int max = 0;
		int s[] = new int[4];
		int result[] = {0,0,0,0};
		int k = 0;
		System.out.println("Enter number");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		for(int i = number; i>0; i--)
		{
			max = (int) Math.floor(Math.sqrt(number));
			k = 5;
			for (int w = 1; w <= max; w ++)
			{
				for (int x=1; x<=w; x++)
				{
					for (int y=1; y<=x; y++)
					{
						for (int z=1; z<=y; z++)
						{
							s[0]=w*w;
							s[1]=s[0]+x*x;
							s[2]=s[1]+y*y;
							s[3]=s[2]+z*z;
							for (int j=0; j<4; j++)
							{
								if (i==s[j]) 
								{
									if (j<k) 
									{
										k = j;
									}
								}
							}
						}
					}
				}
			}
			result[k]++;
		}
		System.out.println("First value : "+result[0]+" Second value : "+result[1]
						  +" Third value : "+result[2]+" Forth value : "+result[3]);
/*
 * int N;
    int max;
    int s[4];
    int res[4]={0,0,0,0};
    int k;
    cin>>N;

    for (int i=N; i>0; i--) {
        max=floor(sqrt(N));
        k=5;
        for (int w=1; w<=max; w++) {
            for (int x=1; x<=w; x++) {
                for (int y=1; y<=x; y++) {
                    for (int z=1; z<=y; z++) {
                        s[0]=w*w;
                        s[1]=s[0]+x*x;
                        s[2]=s[1]+y*y;
                        s[3]=s[2]+z*z;
                        for (int j=0; j<4; j++) {
                            if (i==s[j]) {
                                if (j<k) {
                                    k=j;
                                };
                            };
                        };

                    };
                };
            };
        };
        res[k]++;
    };
    cout<<res[0]<<" "<<res[1]<<" "<<res[2]<<" "<<res[3];*/
	}

}
