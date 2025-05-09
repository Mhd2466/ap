package ap.excercises.ex4;

public class Person {
    private String name;
    private String friends;

    public Person(String name) {
        this.name = name;
        this.friends = "";
    }

    public void befriend(Person p) {
        if (!friends.contains(p.name)) {
            if (friends.isEmpty()) {
                friends = p.name;
            } else {
                friends += " " + p.name;
            }
        }
    }

    public void unfriend(Person p) {
        String[] friendArray = friends.split(" ");
        String newFriends = "";
        for (String f : friendArray) {
            if (!f.equals(p.name)) {
                if (newFriends.isEmpty()) {
                    newFriends = f;
                } else {
                    newFriends += " " + f;
                }
            }
        }
        friends = newFriends;
    }

    public String getFriendNames() {
        return friends;
    }
}
