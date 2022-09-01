###
### Author: Justin Taylor
### Description: This program enables the user to use preset
###              avatars or create their own avatar.
###
from os import _exit as exit
# Ask for inputs and make avatar if initial input is 'custom'

def custom_type():
    '''
        This function will ask for many user inputs and
        make a custom avatar based on what the user
        enters for the inputs.
    '''
    print('Answer the following questions to create a custom avatar')
    hat_style = input('Hat style ? \n')
    eyes_char = input('Character for eyes ? \n')
    hair = input('Shaggy hair (True/False) ? \n')
    arm_style = input('Arm style ? \n')
    torso_length = int(input('Torso length ? \n'))
    leg_length = int(input('Leg length (1-4) ? \n'))
    shoe_style = input('Shoe look ? \n')
    print('\n', end='')
    print('       ~-~       ')
    print('     /-~-~-\\    ')
    # Make if-statements for validation
    if hat_style == 'left':
        print(' ___/_______\\')
    elif hat_style == 'right':
        print('    /_______\\___')
    elif hat_style == 'both':
        print(' ___/_______\\___')
    elif hat_style == 'front':
        print('    /_______\\')
    if hair == 'True':
        print('    |"""""""|')
    elif hair == 'False':
        print("    |'''''''|")
    print('    | ' + eyes_char + '   ' + eyes_char + ' |')
    print('    |   V   |')
    print('    |  ~~~  |')
    print('     \\_____/')
    print(' 0' + arm_style + arm_style + arm_style + arm_style + '|---|' + arm_style + arm_style + arm_style + arm_style + '0')
    while torso_length > 0:
        print('      |-X-|')
        torso_length -= 1
    print('      HHHHH')
    if leg_length == 1:
        print('     /// \\\\\\')
    elif leg_length == 2:
        print('     /// \\\\\\')
        print('    ///   \\\\\\')
    elif leg_length == 3:
        print('     /// \\\\\\')
        print('    ///   \\\\\\')
        print('   ///     \\\\\\')
    elif leg_length == 4:
        print('     /// \\\\\\')
        print('    ///   \\\\\\')
        print('   ///     \\\\\\')
        print('  ///       \\\\\\')
    print(shoe_style + '       ' + shoe_style)

def Jeff_type():
    '''
        This function will print out the "Jeff"
        avatar if the user enters it for the avatar
        type.
    '''
    print('\n', end='')
    print('       ~-~       ')
    print('     /-~-~-\\    ')
    print(' ___/_______\\___')
    print('    |"""""""|')
    print('    | 0   0 |')
    print('    |   V   |')
    print('    |  ~~~  |')
    print('     \\_____/')
    print(' 0====|---|====0')
    print('      |-X-|')
    print('      |-X-|')
    print('      HHHHH')
    print('     /// \\\\\\')
    print('    ///   \\\\\\')
    print('#HHH#       #HHH#')

def Adam_type():
    '''
        This function will print out the "Adam"
        avatar if the user enters it for the avatar
        type.
    '''
    print('\n', end='')
    print('       ~-~       ')
    print('     /-~-~-\\    ')
    print('    /_______\\___')
    print("    |'''''''|")
    print('    | *   * |')
    print('    |   V   |')
    print('    |  ~~~  |')
    print('     \\_____/')
    print('      |-X-|')
    print(' 0TTTT|---|TTTT0')
    print('      |-X-|')
    print('      |-X-|')
    print('      |-X-|')
    print('      HHHHH')
    print('     /// \\\\\\')
    print('    ///   \\\\\\')
    print('   ///     \\\\\\')
    print('<|||>       <|||>')

def Chris_type():
    '''
        This function will print out the "Chris"
        avatar if the user enters it for the avatar
        type.
    '''
    print('\n', end='')
    print('       ~-~       ')
    print('     /-~-~-\\    ')
    print('    /_______\\')
    print('    |"""""""|')
    print('    | U   U |')
    print('    |   V   |')
    print('    |  ~~~  |')
    print('     \\_____/')
    print('      |-X-|')
    print(' 0WWWW|---|WWWW0')
    print('      |-X-|')
    print('      HHHHH')
    print('     /// \\\\\\')
    print('    ///   \\\\\\')
    print('   ///     \\\\\\')
    print('  ///       \\\\\\')
    print('<>-<>       <>-<>')

def exit_type():
    '''
        This function will exit the program if the user
        enters "exit"
    '''
    exit(0)

# Define main function
def main():
    print('----- AVATAR -----')
    avatar_type = input('Select an Avatar or create your own: \n')
    # Make if-statements for validation
    while avatar_type != 'Jeff' and avatar_type != 'Adam' and avatar_type != 'Chris' and avatar_type != 'exit' and avatar_type != 'custom':
        avatar_type = input('Select an Avatar or create your own: \n')

    if avatar_type == 'Jeff':
        Jeff_type()
    elif avatar_type == 'Adam':
        Adam_type()
    elif avatar_type == 'Chris':
        Chris_type()
    elif avatar_type == 'custom':
        custom_type()
    elif avatar_type == 'exit':
        exit_type()

main()